@Test public void testDuplicateDates(){
  String now=ISO8601.format(Calendar.getInstance());
  SegmentWriter writer=new MemoryStore().getTracker().getWriter();
  SegmentNodeBuilder builder=writer.writeNode(EMPTY_NODE).builder();
  builder.setProperty(PropertyStates.createProperty("test",Collections.nCopies(1,now),Type.DATES));
  RecordId id1=builder.getNodeState().getRecordId();
  builder.setProperty(PropertyStates.createProperty("test",Collections.nCopies(12,now),Type.DATES));
  RecordId id2=builder.getNodeState().getRecordId();
  assertEquals(16 + 12 * Segment.RECORD_ID_BYTES,id1.getOffset() - id2.getOffset());
  builder.setProperty(PropertyStates.createProperty("test",Collections.nCopies(100,now),Type.DATES));
  RecordId id3=builder.getNodeState().getRecordId();
  assertEquals(16 + 100 * Segment.RECORD_ID_BYTES,id2.getOffset() - id3.getOffset());
}
