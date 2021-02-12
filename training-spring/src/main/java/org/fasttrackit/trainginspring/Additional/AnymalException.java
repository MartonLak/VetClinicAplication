package org.fasttrackit.trainginspring.Additional;

 public class AnymalException extends RuntimeException
{
    public AnymalException(Long id) {
        super("Could not find employee " + id);
    }
}
