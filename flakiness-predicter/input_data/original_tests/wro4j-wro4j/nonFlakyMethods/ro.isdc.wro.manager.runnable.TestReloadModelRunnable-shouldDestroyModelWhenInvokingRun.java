@Test public void shouldDestroyModelWhenInvokingRun(){
  victim.run();
  Mockito.verify(mockModelFactory).destroy();
}
