@Test public void shouldMergeNotEmptyModel(){
  victim.merge(new WroModel().addGroup(new Group("anEmptyGroup")));
  assertEquals(Arrays.asList("anEmptyGroup","g1","g2","g3"),new WroModelInspector(victim).getGroupNames());
}
