@Test public void shouldDestroyModelWhenInvokingRun(){
  victim.run();
  Mockito.verify(mockCacheStrategy).clear();
}
