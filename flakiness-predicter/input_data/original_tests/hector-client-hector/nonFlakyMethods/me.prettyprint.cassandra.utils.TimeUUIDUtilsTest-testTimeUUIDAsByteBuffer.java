@Test public void testTimeUUIDAsByteBuffer(){
  UUID expectedUuid=TimeUUIDUtils.getUniqueTimeUUIDinMillis();
  UUID actualUuid=TimeUUIDUtils.uuid(TimeUUIDUtils.asByteBuffer(expectedUuid));
  assertEquals(expectedUuid,actualUuid);
}
