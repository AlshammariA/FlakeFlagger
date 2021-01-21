@Test public void testFlatNodeUpdate(){
  SegmentStore store=new MemoryStore();
  SegmentWriter writer=store.getTracker().getWriter();
  NodeBuilder builder=EMPTY_NODE.builder();
  for (int i=0; i < 1000; i++) {
    builder.child("child" + i);
  }
  SegmentNodeState state=writer.writeNode(builder.getNodeState());
  writer.flush();
  Segment segment=store.readSegment(state.getRecordId().getSegmentId());
  assertEquals(27520,segment.size());
  writer.flush();
  builder=state.builder();
  builder.child("child1000");
  state=writer.writeNode(builder.getNodeState());
  writer.flush();
  segment=store.readSegment(state.getRecordId().getSegmentId());
  assertEquals(496,segment.size());
}
