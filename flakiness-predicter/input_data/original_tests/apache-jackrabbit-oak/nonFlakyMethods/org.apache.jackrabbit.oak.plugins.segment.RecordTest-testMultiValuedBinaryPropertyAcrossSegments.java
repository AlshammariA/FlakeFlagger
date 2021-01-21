@Test public void testMultiValuedBinaryPropertyAcrossSegments() throws IOException {
  byte[] data=new byte[Segment.MEDIUM_LIMIT - 1];
  random.nextBytes(data);
  List<Blob> blobs=newArrayList();
  while (blobs.size() * data.length < Segment.MAX_SEGMENT_SIZE) {
    blobs.add(writer.writeStream(new ByteArrayInputStream(data)));
  }
  NodeBuilder builder=EMPTY_NODE.builder();
  builder.setProperty("test",blobs,BINARIES);
  NodeState state=writer.writeNode(builder.getNodeState());
  for (  Blob blob : state.getProperty("test").getValue(BINARIES)) {
    try {
      blob.getNewStream().close();
    }
 catch (    IllegalStateException e) {
      fail("OAK-1374");
    }
  }
}
