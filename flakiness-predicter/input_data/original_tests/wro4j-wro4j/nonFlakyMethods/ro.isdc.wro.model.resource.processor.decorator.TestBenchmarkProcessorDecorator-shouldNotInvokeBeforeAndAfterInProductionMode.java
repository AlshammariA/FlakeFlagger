@Test public void shouldNotInvokeBeforeAndAfterInProductionMode() throws Exception {
  Context.get().getConfig().setDebug(false);
  victim.process(mockResource,mockReader,mockWriter);
  Mockito.verify(mockBefore,Mockito.never()).run();
  Mockito.verify(mockAfter,Mockito.never()).run();
}
