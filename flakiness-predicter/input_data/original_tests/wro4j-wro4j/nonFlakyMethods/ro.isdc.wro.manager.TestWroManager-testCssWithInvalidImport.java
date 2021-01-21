/** 
 * Test that when ignoreMissingResource is true and IOException is thrown by a processor, no exception is thrown.
 */
@Test public void testCssWithInvalidImport() throws Exception {
  new GenericTestBuilder().processAndCompare("/invalidImport.css","classpath:ro/isdc/wro/manager/invalidImport-out.css");
}
