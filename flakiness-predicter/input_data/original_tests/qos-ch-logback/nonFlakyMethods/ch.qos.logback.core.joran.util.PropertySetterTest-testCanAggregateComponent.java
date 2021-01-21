@Test public void testCanAggregateComponent(){
  assertEquals(AggregationType.AS_COMPLEX_PROPERTY,setter.computeAggregationType("door"));
  assertEquals(AggregationType.AS_BASIC_PROPERTY,setter.computeAggregationType("count"));
  assertEquals(AggregationType.AS_BASIC_PROPERTY,setter.computeAggregationType("Count"));
  assertEquals(AggregationType.AS_BASIC_PROPERTY,setter.computeAggregationType("name"));
  assertEquals(AggregationType.AS_BASIC_PROPERTY,setter.computeAggregationType("Name"));
  assertEquals(AggregationType.AS_BASIC_PROPERTY,setter.computeAggregationType("Duration"));
  assertEquals(AggregationType.AS_BASIC_PROPERTY,setter.computeAggregationType("fs"));
  assertEquals(AggregationType.AS_BASIC_PROPERTY,setter.computeAggregationType("open"));
  assertEquals(AggregationType.AS_BASIC_PROPERTY,setter.computeAggregationType("Open"));
  assertEquals(AggregationType.AS_COMPLEX_PROPERTY_COLLECTION,setter.computeAggregationType("Window"));
  assertEquals(AggregationType.AS_BASIC_PROPERTY_COLLECTION,setter.computeAggregationType("adjective"));
  assertEquals(AggregationType.AS_BASIC_PROPERTY,setter.computeAggregationType("filterReply"));
  assertEquals(AggregationType.AS_BASIC_PROPERTY,setter.computeAggregationType("houseColor"));
  System.out.println();
}
