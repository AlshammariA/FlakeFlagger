@Test public void shouldHaveConfiguredLints(){
  victim.setLints(Arrays.asList("1","2","3"));
  assertEquals(3,victim.getLints().size());
}
