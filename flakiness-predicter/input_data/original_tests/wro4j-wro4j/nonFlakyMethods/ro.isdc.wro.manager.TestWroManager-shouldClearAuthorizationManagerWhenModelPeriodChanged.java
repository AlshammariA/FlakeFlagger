@Test public void shouldClearAuthorizationManagerWhenModelPeriodChanged(){
  victim.onModelPeriodChanged(1);
  verify(mockAuthorizationManager,atLeastOnce()).clear();
}
