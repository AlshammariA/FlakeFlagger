@Test public void testOpenAndClose(){
  assertTrue(hThriftClient.open().isOpen());
  assertFalse(hThriftClient.close().isOpen());
}
