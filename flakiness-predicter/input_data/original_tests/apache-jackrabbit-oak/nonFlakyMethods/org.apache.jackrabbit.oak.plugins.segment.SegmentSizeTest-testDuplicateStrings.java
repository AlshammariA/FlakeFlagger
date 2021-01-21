@Test public void testDuplicateStrings(){
  String string="More than just a few bytes of example content.";
  SegmentWriter writer=new MemoryStore().getTracker().getWriter();
  SegmentNodeBuilder builder=writer.writeNode(EMPTY_NODE).builder();
  builder.setProperty(PropertyStates.createProperty("test",Collections.nCopies(1,string),Type.STRINGS));
  RecordId id1=builder.getNodeState().getRecordId();
  builder.setProperty(PropertyStates.createProperty("test",Collections.nCopies(12,string),Type.STRINGS));
  RecordId id2=builder.getNodeState().getRecordId();
  assertEquals(16 + 12 * Segment.RECORD_ID_BYTES,id1.getOffset() - id2.getOffset());
  builder.setProperty(PropertyStates.createProperty("test",Collections.nCopies(100,string),Type.STRINGS));
  RecordId id3=builder.getNodeState().getRecordId();
  assertEquals(16 + 100 * Segment.RECORD_ID_BYTES,id2.getOffset() - id3.getOffset());
}
