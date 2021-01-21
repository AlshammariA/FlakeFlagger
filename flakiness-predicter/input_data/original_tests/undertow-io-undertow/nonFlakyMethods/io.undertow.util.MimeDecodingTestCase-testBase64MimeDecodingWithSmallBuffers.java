@Test public void testBase64MimeDecodingWithSmallBuffers() throws IOException {
  final String data=fixLineEndings(FileUtils.readFile(MimeDecodingTestCase.class,"mime3.txt"));
  TestPartHandler handler=new TestPartHandler();
  MultipartParser.ParseState parser=MultipartParser.beginParse(new ByteBufferSlicePool(BufferAllocator.DIRECT_BYTE_BUFFER_ALLOCATOR,6,6 * 6),handler,"unique-boundary-1".getBytes());
  ByteBuffer buf=ByteBuffer.wrap(data.getBytes());
  parser.parse(buf);
  Assert.assertTrue(parser.isComplete());
  Assert.assertEquals(2,handler.parts.size());
  Assert.assertEquals("This is some base64 text.",handler.parts.get(0).data.toString());
  Assert.assertEquals("This is some more base64 text.",handler.parts.get(1).data.toString());
  Assert.assertEquals("text/plain",handler.parts.get(0).map.getFirst(Headers.CONTENT_TYPE));
}
