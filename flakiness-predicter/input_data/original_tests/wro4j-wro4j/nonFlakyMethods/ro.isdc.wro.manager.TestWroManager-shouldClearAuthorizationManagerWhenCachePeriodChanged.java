@Test public void shouldClearAuthorizationManagerWhenCachePeriodChanged(){
  victim.onCachePeriodChanged(1);
  verify(mockAuthorizationManager,atLeastOnce()).clear();
}
