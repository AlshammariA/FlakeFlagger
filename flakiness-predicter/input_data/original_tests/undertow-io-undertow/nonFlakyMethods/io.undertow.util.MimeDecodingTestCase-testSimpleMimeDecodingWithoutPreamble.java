@Test public void testSimpleMimeDecodingWithoutPreamble() throws IOException {
  final String data=fixLineEndings(FileUtils.readFile(MimeDecodingTestCase.class,"mime2.txt"));
  TestPartHandler handler=new TestPartHandler();
  MultipartParser.ParseState parser=MultipartParser.beginParse(bufferPool,handler,"unique-boundary-1".getBytes());
  ByteBuffer buf=ByteBuffer.wrap(data.getBytes());
  parser.parse(buf);
  Assert.assertTrue(parser.isComplete());
  Assert.assertEquals(2,handler.parts.size());
  Assert.assertEquals("Here is some text.",handler.parts.get(0).data.toString());
  Assert.assertEquals("Here is some more text.",handler.parts.get(1).data.toString());
  Assert.assertEquals("text/plain",handler.parts.get(0).map.getFirst(Headers.CONTENT_TYPE));
}
