package crosswordgame;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Calendar;


public class StatisticsData implements java.io.Serializable {
        String gamename;
        String user;
        int score;
        float percentCorrect;
        int wordCount;
        int wordComp;
        Calendar startDate;
        Calendar endDate;
        int A;
        int B;
         
        public StatisticsData(){
            startDate=Calendar.getInstance();
            percentCorrect=0;
            A=1;
            B=1;
        }

        public void calculateEndGameData(){
            endDate=Calendar.getInstance();
            calculateScore();
        }
        
        public String getTimeElapsed(Calendar current){
            long timediff=(int)(current.getTimeInMillis()-startDate.getTimeInMillis());
            int day =(int)(timediff/(1000*60*60*24));
            int hour=(int)(timediff%(1000*60*60*24))/(1000*60*60);
            int minute=(int) ((timediff%(1000*60*60*24))%(1000*60*60))/(1000*60);
            int second= (int)(((timediff%(1000*60*60*24))%(1000*60*60))%(1000*60))/1000;
            return ((day<10)?("0"+day) : day) +":"+((hour<10)?("0"+hour) : hour) +":"+((minute<10)?("0"+minute) : minute) +":"+((second<10)?("0"+second) : second);
        }
        
        public void calculateScore(){
            int timediff=(int)(endDate.getTimeInMillis()-startDate.getTimeInMillis())/1000;
            score=wordComp*10*A+(int)((B*wordComp*wordCount)/timediff);
        }
        
        
        
}

class StatsScoreComparator implements Comparator<StatisticsData> {
    @Override
    public int compare(StatisticsData o1, StatisticsData o2) {
        return o2.score-o1.score;
    }
}
