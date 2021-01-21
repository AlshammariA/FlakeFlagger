@Test public void testStringRecord(){
  RecordId empty=writer.writeString("");
  RecordId space=writer.writeString(" ");
  RecordId hello=writer.writeString("Hello, World!");
  StringBuilder builder=new StringBuilder();
  for (int i=0; i < 2 * Segment.MAX_SEGMENT_SIZE + 1000; i++) {
    builder.append((char)('0' + i % 10));
  }
  RecordId large=writer.writeString(builder.toString());
  Segment segment=large.getSegmentId().getSegment();
  assertEquals("",segment.readString(empty));
  assertEquals(" ",segment.readString(space));
  assertEquals("Hello, World!",segment.readString(hello));
  assertEquals(builder.toString(),segment.readString(large));
}
