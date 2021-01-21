@Test public void getLane(){
  OrderedContentMirrorStoreStrategy store=new OrderedContentMirrorStoreStrategy();
  Random generator=null;
  generator=createNiceMock(Random.class);
  expect(generator.nextDouble()).andReturn(0.73).anyTimes();
  replay(generator);
  assertEquals(0,store.getLane(generator));
  generator=createNiceMock(Random.class);
  expect(generator.nextDouble()).andReturn(0.02).once();
  expect(generator.nextDouble()).andReturn(0.73).once();
  replay(generator);
  assertEquals(1,store.getLane(generator));
  generator=createNiceMock(Random.class);
  expect(generator.nextDouble()).andReturn(0.02).times(2);
  expect(generator.nextDouble()).andReturn(0.73).once();
  replay(generator);
  assertEquals(2,store.getLane(generator));
  generator=createNiceMock(Random.class);
  expect(generator.nextDouble()).andReturn(0.02).times(3);
  expect(generator.nextDouble()).andReturn(0.73).once();
  replay(generator);
  assertEquals(3,store.getLane(generator));
  generator=createNiceMock(Random.class);
  expect(generator.nextDouble()).andReturn(0.02).times(OrderedIndex.LANES);
  expect(generator.nextDouble()).andReturn(0.73).once();
  replay(generator);
  assertEquals("we should never go beyond 4 lanes",OrderedIndex.LANES - 1,store.getLane(generator));
}
