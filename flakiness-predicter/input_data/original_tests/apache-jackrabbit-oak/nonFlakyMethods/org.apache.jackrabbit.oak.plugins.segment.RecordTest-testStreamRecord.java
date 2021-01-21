@Test public void testStreamRecord() throws IOException {
  checkRandomStreamRecord(0);
  checkRandomStreamRecord(1);
  checkRandomStreamRecord(0x79);
  checkRandomStreamRecord(0x80);
  checkRandomStreamRecord(0x4079);
  checkRandomStreamRecord(0x4080);
  checkRandomStreamRecord(SegmentWriter.BLOCK_SIZE);
  checkRandomStreamRecord(SegmentWriter.BLOCK_SIZE + 1);
  checkRandomStreamRecord(Segment.MAX_SEGMENT_SIZE);
  checkRandomStreamRecord(Segment.MAX_SEGMENT_SIZE + 1);
  checkRandomStreamRecord(Segment.MAX_SEGMENT_SIZE * 2);
  checkRandomStreamRecord(Segment.MAX_SEGMENT_SIZE * 2 + 1);
}
