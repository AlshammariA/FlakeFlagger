@Test public void shouldReturnEmptyListOfProcessors(){
  assertEquals(Collections.EMPTY_LIST,victim.getPreProcessors());
  assertEquals(Collections.EMPTY_LIST,victim.getPostProcessors());
}
