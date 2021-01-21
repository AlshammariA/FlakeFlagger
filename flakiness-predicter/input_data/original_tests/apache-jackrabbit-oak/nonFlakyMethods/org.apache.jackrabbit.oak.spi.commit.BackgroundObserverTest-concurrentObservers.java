/** 
 * Assert that each observer of many running concurrently sees the same linearly sequence of commits (i.e. sees the commits in the correct order).
 */
@Test public void concurrentObservers() throws InterruptedException {
  Observer observer=createCompositeObserver(newFixedThreadPool(16),128);
  for (int k=0; k < CHANGE_COUNT; k++) {
    contentChanged(observer,k);
  }
  done(observer);
  assertTrue(doneCounter.await(5,TimeUnit.SECONDS));
  for (  Runnable assertion : assertions) {
    assertion.run();
  }
}
