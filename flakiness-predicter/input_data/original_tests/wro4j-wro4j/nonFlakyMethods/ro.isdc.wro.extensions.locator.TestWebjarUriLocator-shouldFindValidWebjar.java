@Test public void shouldFindValidWebjar() throws Exception {
  assertNotEmpty(victim.locate("webjar:jquery.js"));
  assertNotEmpty(victim.locate("webjar:jquery/2.0.0/jquery.js"));
  assertNotEmpty(victim.locate("webjar:/jquery/2.0.0/jquery.js"));
}
