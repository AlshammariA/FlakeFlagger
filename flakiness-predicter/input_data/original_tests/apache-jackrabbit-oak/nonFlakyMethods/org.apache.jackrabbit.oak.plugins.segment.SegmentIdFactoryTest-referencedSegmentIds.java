@Test public void referencedSegmentIds() throws InterruptedException {
  SegmentId a=factory.newDataSegmentId();
  SegmentId b=factory.newBulkSegmentId();
  SegmentId c=factory.newDataSegmentId();
  Set<SegmentId> ids=factory.getReferencedSegmentIds();
  assertTrue(ids.contains(a));
  assertTrue(ids.contains(b));
  assertTrue(ids.contains(c));
  assertFalse(ids.contains(factory.newBulkSegmentId()));
}
