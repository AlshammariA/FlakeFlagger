@Test public void should_return_true_if_arrays_of_Objects_are_equal(){
  Object[] a1={"Luke","Yoda","Leia"};
  Object[] a2={"Luke","Yoda","Leia"};
  assertTrue(standardComparisonStrategy.areEqual(a1,a2));
}
