@Test public void should_return_hashCode_of_intarray(){
  int[] intArray=new int[]{1,2,3};
  assertThat(hashCodeFor(intArray)).isEqualTo(intArray.hashCode());
}
