package org.fasttrackit.trainginspring;

import org.fasttrackit.trainginspring.Additional.Species;
import org.fasttrackit.trainginspring.Entity.Animals;
import org.fasttrackit.trainginspring.Entity.AnimalsOriginal;
import org.fasttrackit.trainginspring.Service.AnimalService;
import org.fasttrackit.trainginspring.repo.AnimalRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


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
		expectedEntity.setSpice(Species.DOG);
		Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(expectedEntity);
		AnimalsOriginal actual = service.createNewAnimal(new AnimalsOriginal());
		Assertions.assertNotNull(actual);
		Assertions.assertEquals("Marton",actual.getName());
		Assertions.assertEquals(Species.DOG,actual.getSpice());
	}
}
