/** 
 * See OAK-1233 and OAK-1479
 */
@Test(expected=IllegalStateException.class) public void testData(){
  List<Iterator<Revision>> iterators=prepareData();
  final Iterator<Iterator<Revision>> it=iterators.iterator();
  final Comparator<Revision> comp=StableRevisionComparator.REVERSE;
  MergeSortedIterators<Revision> sort=new MergeSortedIterators<Revision>(comp){
    @Override public Iterator<Revision> nextIterator(){
      return it.hasNext() ? it.next() : null;
    }
  }
;
  while (sort.hasNext()) {
    sort.next();
  }
}
