/** 
 * Runs all of the tests under a single JUnit test method.  We consolidate all testing to one method because HBaseClusterTestCase is prone to OutOfMemoryExceptions when there are three or more JUnit test methods.
 * @throws Exception
 */
public void testAll() throws Exception {
  doTestTableCreateDrop();
  doTestTableMutations();
  doTestTableTimestampsAndColumns();
  doTestTableScanners();
}
