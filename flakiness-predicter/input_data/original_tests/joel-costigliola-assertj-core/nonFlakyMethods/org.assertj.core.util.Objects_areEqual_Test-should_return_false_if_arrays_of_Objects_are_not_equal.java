@Test public void should_return_false_if_arrays_of_Objects_are_not_equal(){
  Object[] a1={"Luke","Yoda","Leia"};
  Object[] a2=new Object[0];
  assertFalse(Objects.areEqual(a1,a2));
}
