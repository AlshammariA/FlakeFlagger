@Test public void shouldNotFailWhenContextInitializedAndDestroyed(){
  victim.contextInitialized(mockServletContextEvent);
  victim.contextDestroyed(mockServletContextEvent);
  victim.contextInitialized(mockServletContextEvent);
}
