@Test public void should_return_false_if_arrays_of_primitives_are_not_equal(){
  int[] a1={6,8,10};
  boolean[] a2={true};
  assertFalse(Objects.areEqual(a1,a2));
}
