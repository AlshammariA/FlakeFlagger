@Test public void should_return_toString_of_array_of_arrays(){
  String[][] array=array(array("s1","s2"),array("s3","s4","s5"));
  assertEquals("[[\"s1\", \"s2\"], [\"s3\", \"s4\", \"s5\"]]",new StandardRepresentation().toStringOf(array));
}
