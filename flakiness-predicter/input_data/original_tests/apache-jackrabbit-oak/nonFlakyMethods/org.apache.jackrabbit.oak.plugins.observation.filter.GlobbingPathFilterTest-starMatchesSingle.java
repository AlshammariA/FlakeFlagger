/** 
 * * should match q
 */
@Test public void starMatchesSingle(){
  EventFilter filter=new GlobbingPathFilter(STAR);
  assertTrue(filter.includeAdd("q",tree.getNodeState()));
}
