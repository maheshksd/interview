package programs.java8.lamda.counstructor;

@FunctionalInterface
public interface TriFunction<A,B,C,R> {
    R apply(A a,B b,C c);
}
