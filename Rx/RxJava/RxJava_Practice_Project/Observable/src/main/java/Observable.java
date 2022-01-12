public class Observable<I extends Number> {
    Observable<Integer> observableString =
            Observable.create(new Observable.OnSubscribe<Integer>() {
                @Override
                public void call(Subscriber<? super Integer> observer){
                    for (int i = 0; i < 5; i++){
                        observer.onNext(i);
                    }
                    observer.onCompleted();
                }
            })
}
