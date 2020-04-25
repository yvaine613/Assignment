package au.edu.unsw.infs3634.assignmentui;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import au.edu.unsw.infs3634.assignmentui.db.Question;
import au.edu.unsw.infs3634.assignmentui.db.QuestionDao;

public class MainActivity extends AppCompatActivity {

    private LessonFragment mLessonFragment;
    private QuizFragment mQuizFragment;
    private SearchFragment mSearchFragment;
    private ProfileFragment mProfileFragment;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLessonFragment = new LessonFragment();
        mQuizFragment = new QuizFragment();
        mSearchFragment = new SearchFragment();
        mProfileFragment = new ProfileFragment();

        bottomNavigationView = findViewById(R.id.BottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.nav_home) {
                    switchTab(mLessonFragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.nav_quiz) {
                    switchTab(mQuizFragment);
                    return true;
                }else if (menuItem.getItemId() == R.id.nav_search) {
                    switchTab(mSearchFragment);
                    return true;
                }else if (menuItem.getItemId() == R.id.nav_profile) {
                    switchTab(mProfileFragment);
                    return true;
                }
                return false;
            }
        });
        switchTab(mLessonFragment);
        initDb();
    }

    private void initDb() {
        List<Question> dataList = QuestionDao.getInstance(this).loadQuestion("Food","French");
        if (dataList.size()==0) {
            initData();
        }
    }





    private void initData() {
        //    Lesson 1  ---- food
        QuestionDao.getInstance(this).addQuestion(new Question("음식","food","Food","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("빵","bread","Food","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("버터","butter","Food","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("케익","cake","Food","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("치즈","cheese","Food","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("계란","egg","Food","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("우유","milk","Food","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("샐러드","salad","Food","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("소금","salt","Food","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("소시지","sausage","Food","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("스테이크","steak","Food","Korean"));
       // Lesson 2 ----  sports
        QuestionDao.getInstance(this).addQuestion(new Question("양궁","Archery","Sports","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("야구","Baseball","Sports","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("배드민턴","Basketball","Sports","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("농구","Badminton","Sports","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("볼링","Bowling","Sports","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("복싱/권투","Boxing","Sports","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("미식축구"," American Football","Sports","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("골프","Golf","Sports","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("하키","Hockey","Sports","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("스키","Skiing","Sports","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("축구","Football/Soccer","Sports","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("탁구","Table tennis","Sports","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("테니스","Tennis","Sports","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("배구","Volleyball","Sports","Korean"));

    //    Lesson 3 ---- fruits
        QuestionDao.getInstance(this).addQuestion(new Question("과일","fruit","Fruits","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("오렌지","orange","Fruits","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("바나나","banana","Fruits","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("사과","apple","Fruits","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("복숭아","peach","Fruits","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("토마토","tomato","Fruits","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("수박","watermelon","Fruits","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("딸기","strawberry","Fruits","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("체리","cherry","Fruits","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("포도","grape","Fruits","Korean"));
      //  Lesson 4 ---- Animals
        QuestionDao.getInstance(this).addQuestion(new Question("새","bird","Animals","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("개","dog","Animals","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("고양이","cat","Animals","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("쥐","mouse","Animals","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("새","cow","Animals","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("소","bird","Animals","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("돼지","pig","Animals","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("말","horse","Animals","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("양","sheep","Animals","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("토끼","rabbit","Animals","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("닭","chicken","Animals","Korean"));
      //  Lesson 5 ---- weather


        QuestionDao.getInstance(this).addQuestion(new Question("비","rain","Weather","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("눈","snow","Weather","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("화창한","sunny","Weather","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("진눈깨비","sleet","Weather","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("바람","wind","Weather","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("구름","cloud","Weather","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("폭우","heavy rain","Weather","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("얼다","freeze","Weather","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("우박","hail","Weather","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("태풍","typhoon","Weather","Korean"));

        //Lesson 6 ---- body parts

        QuestionDao.getInstance(this).addQuestion(new Question("발","foot","Body Parts","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("다리","leg","Body Parts","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("머리","head","Body Parts","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("목","neck","Body Parts","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("팔","arm","Body Parts","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("손","hand","Body Parts","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("배","stomach","Body Parts","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("몸","body","Body Parts","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("손목","wrist","Body Parts","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("무릎","knee","Body Parts","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("팔꿈치","elbow","Body Parts","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("손가락","finger","Body Parts","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("등","back","Body Parts","Korean"));

      //  Lesson 7 ---- colors

        QuestionDao.getInstance(this).addQuestion(new Question("검은","black","Colors","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("갈색의","brown","Colors","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("회색의","gray","Colors","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("빨간","red","Colors","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("하얀","white","Colors","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("녹색의","green","Colors","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("파란","blue","Colors","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("노란,","yellow","Colors","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("자주색의","purple","Colors","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("금색의","gold","Colors","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("주황색의","orange","Colors","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("분홍색의","pink","Colors","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("은색의","silver","Colors","Korean"));

      //  Lesson 8 ----Aquarium

        QuestionDao.getInstance(this).addQuestion(new Question("상어","shark","Aquarium","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("고래","whale","Aquarium","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("게","crab","Aquarium","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("문어","octopus","Aquarium","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("돌고래","dolphin","Aquarium","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("바다표범","seal","Aquarium","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("해파리","jellyfish","Aquarium","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("오징어","squid","Aquarium","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("물고기","fish","Aquarium","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("바닷가재","lobster","Aquarium","Korean"));

        // Lesson 9 ---- Family



        QuestionDao.getInstance(this).addQuestion(new Question("어머니","mother","Family","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("아버지","father","Family","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("삼촌","uncle","Family","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("고모","aunt","Family","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("사촌","cousin","Family","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("오빠","older brother","Family","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("여동생","younger sister","Family","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("남동생","younger brother","Family","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("언니","older sister","Family","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("할머니","grandmother","Family","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("할아버지","grandfather","Family","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("남편","husband","Family","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("아내","wife","Family","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("아들","son","Family","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("딸","daughter","Family","Korean"));

       // Lesson 10 ----Jobs

        QuestionDao.getInstance(this).addQuestion(new Question("엔지니어","engineer","Jobs","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("프로그래머","programmer","Jobs","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("간호사","nurse","Jobs","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("농부","farmer","Jobs","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("경찰관","police officer","Jobs","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("회사원","office worker","Jobs","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("주부","housewife","Jobs","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("교수","professor","Jobs","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("매니저","manager","Jobs","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("의사","doctor","Jobs","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("변호사","lawyer","Jobs","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("회계사","accountant","Jobs","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("회장","president","Jobs","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("승무원","flight attendant","Jobs","Korean"));
        QuestionDao.getInstance(this).addQuestion(new Question("비서","secretary","Jobs","Korean"));



        //    Lesson 1  ---- food
        QuestionDao.getInstance(this).addQuestion(new Question("パン","Bread","Food","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("バター","Butter","Food","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ケーキ","Cake","Food","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("チーズ","Cheese","Food","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("たまご","Egg","Food","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("にく","Meat","Food","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ぎゅうにゅう","Milk","Food","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ソーセージ","Salt","Food","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("こむぎこ","Flour","Food","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ステーキ","Steak","Food","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("サンドイッチ","Sandwich","Food","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("サラダ","Salad","Food","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("やさい","Vegetables","Food","Japanese"));

        // Lesson 2 ----  sports

        QuestionDao.getInstance(this).addQuestion(new Question("スポーツ","Sport","Sports","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("やきゅう","Baseball","Sports","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("すもう","Sumo Wrestling","Sports","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("すいえい","Swimming","Sports","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("つり, 釣り","Fishing","Sports","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ピンポン","Table Tennis","Sports","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("サッカー","Soccer","Sports","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("テニス","Tennis","Sports","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ゴルフ","Golf","Sports","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("バスケットボール","basketball","Sports","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("フットボール","football","Sports","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("バドミントン","Badminton","Sports","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("スキー","Skiing","Sports","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ランニング","Running","Sports","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("スケート","Skating","Sports","Japanese"));

        //    Lesson 3 ---- fruits


        QuestionDao.getInstance(this).addQuestion(new Question("フルーツ","fruit","Fruits","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("りんご","Apple","Fruits","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("オレンジ","Orange","Fruits","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("バナナ","Banana","Fruits","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("すいか","Watermelon","Fruits","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("いちご","Strawberry","Fruits","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("レモン","Lemon","Fruits","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("もも","Peach","Fruits","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("なし","Mango","Fruits","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ぶどう","Grape","Fruits","Japanese"));

        QuestionDao.getInstance(this).addQuestion(new Question("ざくろ","Pomegranate","Fruits","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("メロン","Melon","Fruits","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("キウイ","Kiwi","Fruits","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("きいちご","Raspberry","Fruits","Japanese"));

        //  Lesson 4 ---- Animals

        QuestionDao.getInstance(this).addQuestion(new Question("ネズミ","Mouse","Animals","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ねこ","Cat","Animals","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("いぬ","Dog","Animals","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("カモ","Wild Duck","Animals","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ウシ","Cattle","Animals","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ウマ","Horse","Animals","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("シマウマ","Zebra","Animals","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ヒツジ","Sheep","Animals","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ブタ","Pig","Animals","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("パンダ","Panda","Animals","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("カンガルー","Kangaroo","Animals","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("オオカミ","Wolf","Animals","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("トラ","Tiger","Animals","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ライオン","Lion","Animals","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ヘビ","Snake","Animals","Japanese"));
        //  Lesson 5 ---- weather
        QuestionDao.getInstance(this).addQuestion(new Question("てんき","Weather","Weather","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("はれ"," Clear Weather / Fair Weather","Weather","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("たいよう","Sun","Weather","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("くも","Cloud","Weather","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ゆき","Snow","Weather","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("あめ","Rain","Weather","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ぼうふうう","Rainstorm","Weather","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("かみなり","Thunder","Weather","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("かぜ","Wind / Breeze","Weather","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("かんそう","Dryness","Weather","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("しっけ","Moisture / Humidity / Damp","Weather","Japanese"));

        //Lesson 6 ---- body parts

        QuestionDao.getInstance(this).addQuestion(new Question("あたま","Head","Body Parts","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("みみ","Ear","Body Parts","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("め","Eye","Body Parts","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("はな","Nose","Body Parts","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("て","Hand","Body Parts","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("はら","Stomach","Body Parts","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ひざ","Knee","Body Parts","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("かお","Face","Body Parts","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ほお/ほほ","Cheek","Body Parts","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("かた","Shoulder","Body Parts","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("あし","Foot / Leg","Body Parts","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("はだ","Skin","Body Parts","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("かかと","Heel","Body Parts","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("くび","Neck","Body Parts","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("くちびる","Lips","Body Parts","Japanese"));

        //  Lesson 7 ---- colors
        QuestionDao.getInstance(this).addQuestion(new Question("いろ","color","Colors","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("オレンジ","orange","Colors","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("きいろ","yellow","Colors","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("あお","blue","Colors","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("あか","red","Colors","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("みどり","green","Colors","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("くろ","black","Colors","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ちゃいろ","brown","Colors","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ピンク","pink","Colors","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("むらさき,","purple","Colors","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("しろ","white","Colors","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("はいいろ","gray","Colors","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("きんいろ","gold","Colors","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ぎんいろ","silver","Colors","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("にじ","rainbow","Colors","Japanese"));

        //  Lesson 8 ----Aquarium
        QuestionDao.getInstance(this).addQuestion(new Question("にしん","herring","Aquarium","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("くらげ","jellyfish","Aquarium","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ロブスター","lobster","Aquarium","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("かに","crab","Aquarium","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("かき","oyster","Aquarium","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("いか","squid","Aquarium","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("さめ","shark","Aquarium","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("いるか","dolphin","Aquarium","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("くじら","whale","Aquarium","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("さけ","salmon","Aquarium","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("ます","trout","Aquarium","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("こい","carp","Aquarium","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("うなぎ","eel","Aquarium","Japanese"));

        // Lesson 9 ---- Family

        QuestionDao.getInstance(this).addQuestion(new Question("そふ","Grandfather","Family","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("そぼ","Grandmother","Family","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("あに","Older Brother","Family","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("あね","older sister","Family","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("おとうと","Younger Brother","Family","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("いもうと","Younger Sister","Family","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("こども","Children","Family","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("むすこ","Son","Family","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("むすめ","Daughter","Family","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("りょうしん","Parents","Family","Japanese"));

        // Lesson 10 ----Jobs
        QuestionDao.getInstance(this).addQuestion(new Question("しょくぎょう","Occupation","Jobs","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("いしゃ","Doctor","Jobs","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("かんごふ","Female Nurse","Jobs","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("かんごし","Nurse","Jobs","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("しかい","Dentist","Jobs","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("かがくしゃ","Scientist","Jobs","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("きょうし","Teacher","Jobs","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("せんせい","Teacher","Jobs","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("かしゅ","Singer","Jobs","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("がか,"," Painter / Artist","Jobs","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("かいけいし","lawyer","Jobs","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("エンジニア","Engineer","Jobs","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("のうみん","Farmer","Jobs","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("きしゃ","Reporter","Jobs","Japanese"));
        QuestionDao.getInstance(this).addQuestion(new Question("けんちくか","Architect","Jobs","Japanese"));

        QuestionDao.getInstance(this).addQuestion(new Question("le dessert","dessert","Food","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("le goûter","snack","Food","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("la soupe","soup","Food","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("un œuf","egg","Food","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("le pain","bread","Food","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("les pâtes","pasta","Food","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("la confiture","jam","Food","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("le riz","rice","Food","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("le sucre","sugar","Food","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("le pain grillé","toast","Food","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("le sel","salt","Food","French"));

// Lesson 2 ----  sports
        QuestionDao.getInstance(this).addQuestion(new Question("basketball","basketball","Sports","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("cricket","cricket","Sports","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("foot(ball)","football/soccer","Sports","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("football américain","American football","Sports","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("golf","golf","Sports","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("hockey","hockey","Sports","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("hockey sur gazon","field hockey","Sports","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("rugby","rugby","Sports","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("tennis","tennis","Sports","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("volley(ball)","volleyball","Sports","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("course","running","Sports","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("boxe","boxing","Sports","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("dance","dancing","Sports","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("randonnée","hiking","Sports","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("cyclisme","cycling","Sports","French"));

        QuestionDao.getInstance(this).addQuestion(new Question("le fruit","fruit","Fruits","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("un ananas","pineapple","Fruits","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("une banane","banana","Fruits","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("une cerise","cherry","Fruits","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("un citron","lemon","Fruits","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("une fraise","strawberry","Fruits","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("une framboise","raspberry","Fruits","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("une myrtille","blueberry","Fruits","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("une orange","orange","Fruits","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("une pastèque","watermelon","Fruits","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("une pêche","peach","Fruits","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("une poire","pear","Fruits","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("une pomme","apple","Fruits","French"));
        QuestionDao.getInstance(this).addQuestion(new Question(" un raisin","grape","Fruits","French"));

        //  Lesson 4 ---- Animals
        QuestionDao.getInstance(this).addQuestion(new Question("chien","dog","Animals","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("chat","cat","Animals","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("lapin","Cat","Animals","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("poisson rouge","rabbit","Animals","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("poissons","fish","Animals","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("serpent","snake","Animals","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("hamster","hamster","Animals","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("lézard","lizard","Animals","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("souris","mouse","Animals","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("rat","rat","Animals","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("oiseau","bird","Animals","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("vache","cow","Animals","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("chèvre","goat","Animals","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("cheval","rooster","Animals","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("poule","chicken","Animals","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("cochon","pig","Animals","French"));
        //  Lesson 5 ---- weather


        QuestionDao.getInstance(this).addQuestion(new Question("La pluie","rain","Weather","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("La grêle","hail","Weather","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("La neige","snow","Weather","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("La tonnerre","thunder","Weather","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("L'arc en ciel","rainbow","Weather","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Il fait froid","Rain","Weather","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Il fait mauvais","cold","Weather","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Il fait du vent","windy","Weather","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Il fait du soleil","sunny","Weather","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("C'est nuageux","cloudy","Weather","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Il gèle","freezing / icy","Weather","French"));

        //Lesson 6 ---- body parts
        QuestionDao.getInstance(this).addQuestion(new Question("La tête","The head","Body Parts","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("La main","Tha hand","Body Parts","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("La jambe","The leg","Body Parts","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Le pied","The foot","Body Parts","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Le visage","The face","Body Parts","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("L'oeil","The eye","Body Parts","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("La bouche","The mouth","Body Parts","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Le coude","The elbow","Body Parts","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Le bras","the arm","Body Parts","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("L'épaule","The shoulder","Body Parts","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Le genou","The knee","Body Parts","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Le cou","The neck","Body Parts","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Le dos","The back","Body Parts","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("L'oreille","The ear","Body Parts","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Les cheveux","The hair","Body Parts","French"));

        //  Lesson 7 ---- colors

        QuestionDao.getInstance(this).addQuestion(new Question("Le Rouge","Red","Colors","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("オレンジ","orange","Colors","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Le Jaune","yellow","Colors","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Le Bleu (m)","Blue","Colors","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Le Noir (m)","Black","Colors","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Le Blanc (m)","White","Colors","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Le Vert (m)","Green","Colors","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("L'Orange","Orange","Colors","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Le Gris (m)","Grey","Colors","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Le Rose,","Pink","Colors","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("L' Argent (m)","Silver","Colors","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("L' Or (m)","gold","Colors","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Le Marron","Brown","Colors","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Le Pourpre","Purple","Colors","French"));

        //  Lesson 8 ----Aquarium


        QuestionDao.getInstance(this).addQuestion(new Question("requin","shark","Aquarium","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("baleine","whale","Aquarium","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Crabe","crab","Aquarium","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("poulpe","octopus","Aquarium","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("dauphin","dolphin","Aquarium","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("joint","seal","Aquarium","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("méduse","jellyfish","Aquarium","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("calamar","squid","Aquarium","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("poisson","fish","Aquarium","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("Homard","lobster","Aquarium","French"));

        // Lesson 9 ---- Family
        QuestionDao.getInstance(this).addQuestion(new Question("les parents","parents","Family","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("le mari","husband","Family","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("la femme","woman / wife","Family","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("le père","father","Family","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("le papa","dad / papa","Family","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("la mère","mother","Family","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("la maman","mom / mama","Family","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("la fille","daughter","Family","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("le fils","son","Family","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("la sœur","sister","Family","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("le frère","brother","Family","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("le demi-frère","half-brother","Family","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("la demi-sœur","half-sister","Family","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("le grand-père","grandfather","Family","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("la grand-mère","grandmother","Family","French"));

        // Lesson 10 ----Jobs
        QuestionDao.getInstance(this).addQuestion(new Question("acteur/actrisse","actor/actress","Jobs","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("agriculteur","farmer","Jobs","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("architecte","architect","Jobs","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("avocat","lawyer","Jobs","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("boulanger","baker","Jobs","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("chanteur","singer","Jobs","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("chauffeur de taxi","taxi driver","Jobs","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("coiffeur/coiffeuse","hairdresser","Jobs","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("conducteur","driver","Jobs","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("cuisinier,","cook","Jobs","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("dentiste","dentist","Jobs","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("enfermière","nurse","Jobs","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("étudiant","student","Jobs","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("étudiant","engineer","Jobs","French"));
        QuestionDao.getInstance(this).addQuestion(new Question("médecin","doctor","Jobs","French"));



        QuestionDao.getInstance(this).addQuestion(new Question("パン","Bread","Food","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("バター","Butter","Food","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ケーキ","Cake","Food","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("チーズ","Cheese","Food","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("たまご","Egg","Food","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("にく","Meat","Food","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ぎゅうにゅう","Milk","Food","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ソーセージ","Salt","Food","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("こむぎこ","Flour","Food","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ステーキ","Steak","Food","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("サンドイッチ","Sandwich","Food","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("サラダ","Salad","Food","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("やさい","Vegetables","Food","German"));

        // Lesson 2 ----  sports

        QuestionDao.getInstance(this).addQuestion(new Question("スポーツ","Sport","Sports","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("やきゅう","Baseball","Sports","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("すもう","Sumo Wrestling","Sports","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("すいえい","Swimming","Sports","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("つり, 釣り","Fishing","Sports","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ピンポン","Table Tennis","Sports","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("サッカー","Soccer","Sports","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("テニス","Tennis","Sports","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ゴルフ","Golf","Sports","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("バスケットボール","basketball","Sports","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("フットボール","football","Sports","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("バドミントン","Badminton","Sports","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("スキー","Skiing","Sports","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ランニング","Running","Sports","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("スケート","Skating","Sports","German"));

        //    Lesson 3 ---- fruits


        QuestionDao.getInstance(this).addQuestion(new Question("フルーツ","fruit","Fruits","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("りんご","Apple","Fruits","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("オレンジ","Orange","Fruits","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("バナナ","Banana","Fruits","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("すいか","Watermelon","Fruits","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("いちご","Strawberry","Fruits","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("レモン","Lemon","Fruits","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("もも","Peach","Fruits","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("なし","Mango","Fruits","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ぶどう","Grape","Fruits","German"));

        QuestionDao.getInstance(this).addQuestion(new Question("ざくろ","Pomegranate","Fruits","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("メロン","Melon","Fruits","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("キウイ","Kiwi","Fruits","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("きいちご","Raspberry","Fruits","German"));

        //  Lesson 4 ---- Animals

        QuestionDao.getInstance(this).addQuestion(new Question("ネズミ","Mouse","Animals","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ねこ","Cat","Animals","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("いぬ","Dog","Animals","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("カモ","Wild Duck","Animals","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ウシ","Cattle","Animals","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ウマ","Horse","Animals","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("シマウマ","Zebra","Animals","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ヒツジ","Sheep","Animals","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ブタ","Pig","Animals","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("パンダ","Panda","Animals","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("カンガルー","Kangaroo","Animals","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("オオカミ","Wolf","Animals","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("トラ","Tiger","Animals","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ライオン","Lion","Animals","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ヘビ","Snake","Animals","German"));
        //  Lesson 5 ---- weather
        QuestionDao.getInstance(this).addQuestion(new Question("てんき","Weather","Weather","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("はれ"," Clear Weather / Fair Weather","Weather","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("たいよう","Sun","Weather","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("くも","Cloud","Weather","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ゆき","Snow","Weather","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("あめ","Rain","Weather","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ぼうふうう","Rainstorm","Weather","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("かみなり","Thunder","Weather","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("かぜ","Wind / Breeze","Weather","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("かんそう","Dryness","Weather","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("しっけ","Moisture / Humidity / Damp","Weather","German"));

        //Lesson 6 ---- body parts

        QuestionDao.getInstance(this).addQuestion(new Question("あたま","Head","Body Parts","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("みみ","Ear","Body Parts","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("め","Eye","Body Parts","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("はな","Nose","Body Parts","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("て","Hand","Body Parts","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("はら","Stomach","Body Parts","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ひざ","Knee","Body Parts","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("かお","Face","Body Parts","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ほお/ほほ","Cheek","Body Parts","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("かた","Shoulder","Body Parts","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("あし","Foot / Leg","Body Parts","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("はだ","Skin","Body Parts","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("かかと","Heel","Body Parts","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("くび","Neck","Body Parts","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("くちびる","Lips","Body Parts","German"));

        //  Lesson 7 ---- colors
        QuestionDao.getInstance(this).addQuestion(new Question("いろ","color","Colors","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("オレンジ","orange","Colors","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("きいろ","yellow","Colors","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("あお","blue","Colors","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("あか","red","Colors","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("みどり","green","Colors","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("くろ","black","Colors","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ちゃいろ","brown","Colors","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ピンク","pink","Colors","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("むらさき,","purple","Colors","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("しろ","white","Colors","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("はいいろ","gray","Colors","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("きんいろ","gold","Colors","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ぎんいろ","silver","Colors","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("にじ","rainbow","Colors","German"));

        //  Lesson 8 ----Aquarium
        QuestionDao.getInstance(this).addQuestion(new Question("にしん","herring","Aquarium","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("くらげ","jellyfish","Aquarium","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ロブスター","lobster","Aquarium","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("かに","crab","Aquarium","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("かき","oyster","Aquarium","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("いか","squid","Aquarium","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("さめ","shark","Aquarium","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("いるか","dolphin","Aquarium","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("くじら","whale","Aquarium","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("さけ","salmon","Aquarium","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("ます","trout","Aquarium","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("こい","carp","Aquarium","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("うなぎ","eel","Aquarium","German"));

        // Lesson 9 ---- Family

        QuestionDao.getInstance(this).addQuestion(new Question("そふ","Grandfather","Family","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("そぼ","Grandmother","Family","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("あに","Older Brother","Family","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("あね","older sister","Family","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("おとうと","Younger Brother","Family","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("いもうと","Younger Sister","Family","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("こども","Children","Family","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("むすこ","Son","Family","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("むすめ","Daughter","Family","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("りょうしん","Parents","Family","German"));

        // Lesson 10 ----Jobs
        QuestionDao.getInstance(this).addQuestion(new Question("しょくぎょう","Occupation","Jobs","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("いしゃ","Doctor","Jobs","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("かんごふ","Female Nurse","Jobs","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("かんごし","Nurse","Jobs","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("しかい","Dentist","Jobs","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("かがくしゃ","Scientist","Jobs","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("きょうし","Teacher","Jobs","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("せんせい","Teacher","Jobs","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("かしゅ","Singer","Jobs","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("がか,"," Painter / Artist","Jobs","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("かいけいし","lawyer","Jobs","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("エンジニア","Engineer","Jobs","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("のうみん","Farmer","Jobs","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("きしゃ","Reporter","Jobs","German"));
        QuestionDao.getInstance(this).addQuestion(new Question("けんちくか","Architect","Jobs","German"));
    }

    private void switchTab(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.FrameLayout_Contain, fragment);
        fragmentTransaction.commit();
    }
}
