@Test public void splitingNullOptionProduceEmptyArray(){
  assertTrue(Arrays.equals(ArrayUtils.EMPTY_STRING_ARRAY,optionsBuilder.splitOptions(null)));
}
