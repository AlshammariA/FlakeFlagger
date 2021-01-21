@Test public void segmentIdType(){
  assertTrue(factory.newDataSegmentId().isDataSegmentId());
  assertTrue(factory.newBulkSegmentId().isBulkSegmentId());
  assertFalse(factory.newDataSegmentId().isBulkSegmentId());
  assertFalse(factory.newBulkSegmentId().isDataSegmentId());
}
