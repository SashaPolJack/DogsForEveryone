Дизайн приложения в Figma - https://www.figma.com/file/hPG3R8m65242aWRVkcNl28/Untitled?type=design&node-id=60%3A2417&mode=dev

В соответствии с патерном MVVM были созданы классы-репозитории для работы с данными, а также классы сущности. Cоздан класс для элемента списка анкет, в нем определены поля имени, картинки, описания, вес и т.д. Реализация представления на листинге 1.
                                                                                <p align="center">Листинг 1 – Класс-сущность собаки</p>

        public class Dog {

            private String name;
            private String Image;
            private String description;
            private String old;
            private Integer weight;
            private String iol;

            public Dog(String name, String image, String description, String old, Integer weight, String iol) {
                this.name = name;
                Image = image;
                this.description = description;
                this.old = old;
                this.weight = weight;
                this.iol = iol;
            }
        
            public String getName() {
                return name;
            }
        
            public String getImage() {
                return Image;
            }
        
            public String getDescription() {
                return description;
            }
        
            public String getOld() {
                return old;
            }
        
            public Integer getWeight() {
                return weight;
            }
        
            public String getIol() {
                return iol;
            }
        }

Для загрузки данных из БД использовался класс-репозиторий для списка анкет собак. Код представлен на листинге 2.
 <p align="center">Листинг 2 – Класс-репозиторий списка анкет собак</p>

        public class DogsRepsitory {
    
            private FirebaseFirestore database;
            private List<DocumentSnapshot> arrayDogsf;
            private MutableLiveData<List<DocumentSnapshot>> mutableLiveDataUser;
            private MutableLiveData<DocumentSnapshot> documentSnapshotMutableLiveData;
        
            public DogsRepsitory(){
                mutableLiveDataUser = new MutableLiveData<>();
                documentSnapshotMutableLiveData = new MutableLiveData<>();
                database = FirebaseFirestore.getInstance();
                database.collection("Dogs").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            arrayDogsf = task.getResult().getDocuments();
                            
        
                        }
                    }
                });
                this.setDogs(arrayDogsf);
            }
        
            public void setDogs(List<DocumentSnapshot> dogs){
                mutableLiveDataUser.setValue(dogs);
            }
            public void setDog(DocumentSnapshot dog){
                documentSnapshotMutableLiveData.setValue(dog);
            }
        
            public MutableLiveData<List<DocumentSnapshot>> getMutableLiveDataUser() {
                return mutableLiveDataUser;
            }
            public  MutableLiveData<DocumentSnapshot> getDocumentSnapshotMutableLiveData(){
                return documentSnapshotMutableLiveData;
            }
        }

Далее был разработан класс-сущности пользователя для записи и чтения из БД. Этот класс содержит поля, которые описывают личные данные пользователя. Код представлен на листинге 3

 <p align="center">Листинг 3 – Класс-сущности пользователя</p>

        public class User_new {
            private String name_str;
            private String email;
            private String pass;
            private String id;
            private int countWalk;
            private int countTake;
            private int countSubcribe;
            private int achive;
        
        
            public int getCountWalk() {
                return countWalk;
            }
        
            public int getCountTake() {
                return countTake;
            }
        
            public int getCountSubcribe() {
                return countSubcribe;
            }
        
            public int getAchive() {
                return achive;
            }
        
            public String getDogs() {
                return dogs;
            }
        
            public int getDollars() {
                return dollars;
            }
        
            public String getDescr() {
                return descr;
            }
        
            private String dogs;
            private int dollars;
            private String descr = "Напиши свой девиз!";
        
            public User_new(String name_str, String email, String pass) {
                this.name_str = name_str;
                this.email = email;
                this.pass = pass;
            }
        
            public void setId(String id) {
                this.id = id;
            }
        
            public String getName_str() {
                return name_str;
            }
        
            public String getEmail() {
                return email;
            }
        
            public String getPass() {
                return pass;
            }
        
            public String getId() {
                return id;
            }
        }

Также разработан класс-репозиторий для поиска, записи в БД пользователя. В этом классе определяем текущего пользователя прри входе или регистрации в приложении. Реализация представлена на листинге 4.
 <p align="center">Листинг 4 – Класс-репозитория пользователя</p>

        public class DataUserRepository {
        private DocumentSnapshot user;
            private MutableLiveData<DocumentSnapshot> mutableLiveDataUser;
            private FirebaseFirestore database;
            public DataUserRepository(String email){
                
                database.collection("Users").whereEqualTo("email",email.toString()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                
                                user = document;
                            }
                        }
                    }
                });
                this.setCurrentUser(user);
            }
        
            public void setCurrentUser(DocumentSnapshot user){
                mutableLiveDataUser.setValue(user);
            }
        
        
            public MutableLiveData<DocumentSnapshot> getMutableLiveDataUser() {
                return mutableLiveDataUser;
            }
        }

Также создан класс-сущности приюта. В нем определены поля, которые описывают приюты. Код представлен на листинге 5.
 <p align="center">Листинг 5 – Класс-сущности приюта</p>

        public class Item_priut_Adapter {
            private String name;
            private String Image;
            private String description;
            private String count_dogs;
            private Integer count_dollars;
            private String take_dogs;
        
            public Item_priut_Adapter(String name, String image, String description, String count_dogs, Integer count_dollars, String take_dogs) {
                this.name = name;
                Image = image;
                this.description = description;
                this.count_dogs = count_dogs;
                this.count_dollars = count_dollars;
                this.take_dogs = take_dogs;
            }
        
            public String getName() {
                return name;
            }
        
            public String getImage() {
                return Image;
            }
        
            public String getDescription() {
                return description;
            }
        
            public String getCount_dogs() {
                return count_dogs;
            }
        
            public Integer getCount_dollars() {
                return count_dollars;
            }
        
            public String getTake_dogs() {
                return take_dogs;
            }
        }

Далее был разработан класс-репозиторий для чтения элементов из БД. В нем мы берем все приюты и в последствии выводим во View. Код представлен на листинге 6
 <p align="center">Листинг 6 – Класс-репозиторий для приютов</p>

        public class PriutsRepository {
            private List<DocumentSnapshot> arrayPriuts;
            private MutableLiveData<List<DocumentSnapshot>> mutableLiveDataUser;
            private FirebaseFirestore database;
            public PriutsRepository(){
                mutableLiveDataUser = new MutableLiveData<>();
                database.collection("Priuts").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            arrayPriuts =  task.getResult().getDocuments();
                            
        
                        }
                    }
                });
                this.setPriut((List<DocumentSnapshot>) arrayPriuts);
            }
        
            public void setPriut(List<DocumentSnapshot> priut){
                mutableLiveDataUser.setValue(priut);
            }
        
        
            public MutableLiveData<List<DocumentSnapshot>> getMutableLiveDataUser() {
                return mutableLiveDataUser;
            }
        
        }

Потом был реализован класс-репозиторий для аутентификации пользователя. В нем есть методы регистрации, входа и выхода пользователя. Код представлен на листинге 7.
 <p align="center">Листинг 7 – Класс-репозиторий для аутентификации</p>
        public class AuotoRepository {
        
            private Application application;
            private MutableLiveData<FirebaseUser> firebaseUserMutableLiveData;
            private FirebaseAuth firebaseAuth;
        
        
            public AuotoRepository(Application application) {
                this.application = application;
                firebaseUserMutableLiveData = new MutableLiveData<>();
                firebaseAuth = FirebaseAuth.getInstance();
        
            }
        
            public MutableLiveData<FirebaseUser> getFirebaseUserMutableLiveData() {
                return firebaseUserMutableLiveData;
            }
        
            public FirebaseUser getCurrentuser() {
                return firebaseAuth.getCurrentUser();
            }
        
            public void singUp(String email, String pass){
                firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            firebaseUserMutableLiveData.postValue(firebaseAuth.getCurrentUser());
                        }else {
                            Toast.makeText(application, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
            public void singIn(String email,String pass){
                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            firebaseUserMutableLiveData.postValue(firebaseAuth.getCurrentUser());
                        }else {
                            Toast.makeText(application, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
            public void singOut(){
                firebaseAuth.signOut();
            }
        }

## Описание серверной части

Для хранения данных используется облачный сервер Firebase, предоставляющий множество возможностей хранения данных. Для использования необходимо подключить свой проект к Firebase [4].
С помощью Firebase Authentication реализована аутентификация пользователя по почте. На рисунке 9 представлен список зарегистрированных пользователей на странице Firebase Authentication.
![image](https://github.com/SashaPolJack/DogsForEveryone/assets/106552046/85a472af-5fd2-47f4-8f9f-37a74a58a9ce)
 <p align="center">Рисунок 9 – Список зарегистрированных пользователей в Firebase</p>

Для хранения личных данных пользователей используется Firebase Firestore Database – NOSQL база данных, в которой записи хранятся как документы в коллекциях. Для кажого пользователя создается запись с полями из класса-сущности. Пример записи пользователя представлен на рисунке 10.
![image](https://github.com/SashaPolJack/DogsForEveryone/assets/106552046/de79a9d8-5756-4061-8ce4-63bbaf9f7c65)
 <p align="center">Рисунок 10 – Пример записи пользователя в Firestore Database</p>

Для хранения записей анкет собак также использовался Firebase Firestore. Была создана коллекция «Dogs», документы в которой представляют собой записи об собаках, они содержат поля, описывающие класс-сущности собаки Пример такого документа в коллекции приведен на рисунке 11.
![image](https://github.com/SashaPolJack/DogsForEveryone/assets/106552046/611e8bda-a8b2-4511-9590-9b2cfba57203)
 <p align="center">Рисунок 11 – Анкета собаки в Firebase Firestore</p>

Также с помощью Firestore реализовано хранение списка анкет приютов. Данные хранятся в коллекции, который содержит документ с полями, описывающие приют. Пример такого документа представлен на рисунке 12.
![image](https://github.com/SashaPolJack/DogsForEveryone/assets/106552046/a122bacf-1435-44fe-aa4c-cb26a4834864)
 <p align="center">Рисунок 12 – Анкета приютов в Firebase Firestore</p>

## Описание клиентской части

Интерфейс приложения создавался по современным требованиям к дизайну. Использовались встроенные в Android Studio инструменты для создания виджетов и разметки. Пример работы в нем представлен на рисунке 13.
![image](https://github.com/SashaPolJack/DogsForEveryone/assets/106552046/0affd250-7c39-463a-ae10-bedd45fbf013)
 <p align="center">Рисунок 13 – Создание разметки экрана в Android Studio</p>

Были реализованы экраны входа, регистрации. Они содержать поля для ввода данных. Их вид представлен на рисунке 14.
 <p align="center"><img src = "https://github.com/SashaPolJack/DogsForEveryone/assets/106552046/e52ab8b1-b23d-4bad-91eb-39ba90554429"></p>
 <p align="center">Рисунок 14 – Вид экранов входа, регистрации</p>

Также при входе или прохождении регистрации пользователь может больше узнать о приложении перейдя к экранам, на которых описаны его основные возможности. Эти экраны представлены на рисунке 15 [1].
![image](https://github.com/SashaPolJack/DogsForEveryone/assets/106552046/9c603e8c-b20d-4508-88e0-407ce1cca431)
 <p align="center">Рисунок 15 – Вид экранов ознакомления с функционалом</p>

После этого пользователь переходит к анкете собак, где может посмотреть всех собачек. С помощью нижнего меню пользователь может перемещаться между экранами профиля, анкетами приютов и анкетами собак. Реализация трех основных экранов, по которым пользователь может перемещаться, представлена на рисунке 16.
<p align="center"><img src = "https://github.com/SashaPolJack/DogsForEveryone/assets/106552046/a10de047-9f9a-456f-977e-bcac0ae32c33"></p>
 <p align="center">Рисунок 16 – Основные экраны приложения</p>

При нажатии на картинку с собакой пользователь преходит на экран профиля собачки. Реализация представлена на рисунке 17.
<p align="center"><img src = "https://github.com/SashaPolJack/DogsForEveryone/assets/106552046/52c133d3-5e2b-43d2-a427-35be91570033"></p>
 <p align="center">Рисунок 17 – Профиль собаки</p>

При нажатии на кнопку «Забрать» появляется экран с календарем, где можно выбрать дату для встречи с собакой. Реализация представлена  на рисунке 18.
<p align="center"><img src = "https://github.com/SashaPolJack/DogsForEveryone/assets/106552046/33753b3e-a2d5-42eb-945c-aa51620afdb4"></p>
 <p align="center">Рисунок 18 – Экран с выбором даты</p>

Также при нажатии на кнопку «Подписаться» пользователь попадает на экран выбора подписки. Экран представлен на рисунке 19.
<p align="center"><img src = "https://github.com/SashaPolJack/DogsForEveryone/assets/106552046/c7d38ae0-863d-4f5d-b938-4eb792e95970"></p>
 <p align="center">Рисунок 19 – Экран с выбором подписки</p>

Навигация в приложении реализована с помощью библиотеки Android Navigation. Она значительно упрощает работу с навигацией благодаря представлению переходов в виде графа. Эта схема представлена на рисунке 20.
<p align="center"><img src = "https://github.com/SashaPolJack/DogsForEveryone/assets/106552046/66c5d198-c9d8-4c68-b68e-2e32ed4ac4e6"></p>
 <p align="center">Рисунок 20 – Граф навигации в приложении</p>
