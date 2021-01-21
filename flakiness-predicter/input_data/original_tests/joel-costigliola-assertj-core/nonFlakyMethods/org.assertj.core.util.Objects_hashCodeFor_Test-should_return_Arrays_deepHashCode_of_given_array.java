@Test public void should_return_Arrays_deepHashCode_of_given_array(){
  String[][] array=new String[][]{array("Yoda")};
  assertThat(hashCodeFor(array)).isEqualTo(deepHashCode(array));
  int[][] intArray=new int[][]{new int[]{5}};
  assertThat(hashCodeFor(intArray)).isEqualTo(deepHashCode(intArray));
}
