@Test(expected=IllegalStateException.class) public void shouldFailWhenMultipleListenersWithSameNameDefined(){
  victim.contextInitialized(mockServletContextEvent);
  victim.contextInitialized(mockServletContextEvent);
}
