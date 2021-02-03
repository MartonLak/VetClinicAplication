package org.fasttrackit.trainginspring;

import org.fasttrackit.trainginspring.Additional.Species;
import org.fasttrackit.trainginspring.model.Entity.Animals;
import org.fasttrackit.trainginspring.model.AnimalsOriginal;
import org.fasttrackit.trainginspring.Service.AnimalService;
import org.fasttrackit.trainginspring.Repo.AnimalRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class AnimalServiceTest
{
	@InjectMocks
	private AnimalService service;
	@Mock
	private AnimalRepo repository;


	@Test
	public void createNewAnimal_expectedValuesFromRepo()
	{
		AnimalsOriginal animalsRequest = new AnimalsOriginal();
		Mockito.when(this.repository.save(ArgumentMatchers.any(Animals.class))).thenReturn(new Animals());
		this.service.createNewAnimal(animalsRequest);
		Mockito.verify(repository).save(ArgumentMatchers.any(Animals.class));

	}
	@Test
	public  void createNewAnimal_expectedActualValuesFromRepository()
	{
		Animals expectedEntity = new Animals();
		expectedEntity.setId(2L);
		expectedEntity.setName("Marton");
		expectedEntity.setSpecies(Species.DOG);
		Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(expectedEntity);
		AnimalsOriginal actual = service.createNewAnimal(new AnimalsOriginal());
		Assertions.assertNotNull(actual);
		Assertions.assertEquals("Marton",actual.getName());
		Assertions.assertEquals(Species.DOG,actual.getSpice());
	}
	@Test
	public void findAnimal_expectedActualValuesFromRepository() {

		Animals expectedEntity = new Animals();
		expectedEntity.setId(0L);
		expectedEntity.setName("Marton");
		expectedEntity.setSpecies(Species.DOG);
		Mockito.doReturn(Optional.of(expectedEntity)).when(repository).findById(0L);
		AnimalsOriginal actual = service.findAnimal(0L);
		Assertions.assertNotNull(actual);
		Assertions.assertEquals("Marton",actual.getName());
		Assertions.assertEquals(Species.DOG,actual.getSpice());
		System.out.println(actual);
	}
	@Test
	public void updateAnimals_expectedActualValuesFromRepository()
	{
		Animals expectedEntity = new Animals();
		expectedEntity.setId(2L);
		expectedEntity.setName("Marton");
		expectedEntity.setSpecies(Species.DOG);
		Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(expectedEntity);
		AnimalsOriginal actual = service.updateAnimals(new AnimalsOriginal());
		Assertions.assertNotNull(actual);
		Assertions.assertEquals("Marton",actual.getName());
		Assertions.assertEquals(Species.DOG,actual.getSpice());
		System.out.println(actual);
	}
	@Test
	public void findallAnimals_expectedActualValuesFromRepository()
	{
		ArrayList<Animals> allAnimal = new ArrayList<Animals>();
		Animals expectedEntity = new Animals();
		Animals expectedEntity2 = new Animals();
		expectedEntity.setId(0L);
		expectedEntity.setName("Marton");
		expectedEntity.setSpecies(Species.DOG);
		expectedEntity2.setId(1L);
		expectedEntity2.setName("Marci");
		expectedEntity2.setSpecies(Species.CAT);
		allAnimal.add(expectedEntity);
		allAnimal.add(expectedEntity2);
		Mockito.when(repository.findAll()).thenReturn(allAnimal);
		List<AnimalsOriginal> actual = service.findAllAnimals();
		Mockito.verify(repository,Mockito.atLeastOnce()).findAll();
		Assertions.assertNotNull(actual);
		Assertions.assertFalse(actual.isEmpty());
		System.out.println(actual);
	}
	@Test
	public void delete_test()
	{
		Animals expectedEntity = new Animals();
		expectedEntity.setId(2L);
		expectedEntity.setName("Marton");
		expectedEntity.setSpecies(Species.DOG);
		repository.deleteById(expectedEntity.getId());
		service.deleteAnimal(2L);

	}

}
