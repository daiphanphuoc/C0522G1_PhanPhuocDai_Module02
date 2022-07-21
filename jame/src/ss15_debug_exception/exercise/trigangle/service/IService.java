package ss15_debug_exception.exercise.trigangle.service;

import ss15_debug_exception.exercise.trigangle._exception.IllegalTriangleException;

public interface IService<E> {
    E create() throws IllegalTriangleException;
}
