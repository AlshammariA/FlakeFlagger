@Test public void shouldCreateConfiguration(){
  victim.contextInitialized(mockServletContextEvent);
  assertNotNull(victim.getConfiguration());
}
