@Test public void splitingTwoOptions(){
  assertTrue(Arrays.equals(new String[]{"o1","o2"},optionsBuilder.splitOptions("o1,o2")));
}
