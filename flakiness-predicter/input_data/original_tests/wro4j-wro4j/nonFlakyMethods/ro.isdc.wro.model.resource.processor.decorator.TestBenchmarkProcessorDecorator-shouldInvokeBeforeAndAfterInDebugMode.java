@Test public void shouldInvokeBeforeAndAfterInDebugMode() throws Exception {
  Context.get().getConfig().setDebug(true);
  victim.process(mockResource,mockReader,mockWriter);
  Mockito.verify(mockBefore).run();
  Mockito.verify(mockAfter).run();
}
