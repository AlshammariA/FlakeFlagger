@Test public void should_return_true_if_arrays_of_primitives_are_equal(){
  int[] a1={6,8,10};
  int[] a2={6,8,10};
  assertTrue(standardComparisonStrategy.areEqual(a1,a2));
}
