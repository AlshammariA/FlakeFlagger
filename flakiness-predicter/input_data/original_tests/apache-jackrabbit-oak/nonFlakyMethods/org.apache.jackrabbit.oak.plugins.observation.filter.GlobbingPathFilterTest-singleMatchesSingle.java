/** 
 * q should match q
 */
@Test public void singleMatchesSingle(){
  EventFilter filter=new GlobbingPathFilter("q");
  assertTrue(filter.includeAdd("q",tree.getNodeState()));
}
