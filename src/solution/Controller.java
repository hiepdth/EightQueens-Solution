/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
/**
 *
 * @author Đinh Thế Hiệp - Vũ Thị Hải Yến
 * @update 28/10/2018
 *
 */
public class Controller implements Initializable {

    private final int n = 8;
    private int count = 0;
    private int current = 0;
    private int[] queens = new int[n];
    private int[] row = {1, 1, 1, 1, 1, 1, 1, 1};
    private int[] cross1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    private int[] cross2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    private final double Time_delay = 1;
    private int TIME = 0;
    private boolean check = false;
    @FXML
    private JFXButton btn_algorithm, btn_play, btn_author, btn_sleep, btn_exit, btn_help, btn_AI, btn_Run;    //các nút chọn chương trình (hiện thị Pane khi chọn)
    @FXML
    private JFXButton btn_nextStep, btn_backStep;
    @FXML
    private ImageView queen1, queen2, queen3, queen4, queen5, queen6, queen7, queen8;   //tạo 8 con hậu cho CasePane
    @FXML
    private ImageView Queen1, Queen2, Queen3, Queen4, Queen5, Queen6, Queen7, Queen0;   //tạo 8 con hậu cho AlgorithmPane
    @FXML
    private ImageView open1, open2, open3, open4;  //mũi tên chỉ đến Pane được chọn
    @FXML
    private AnchorPane algorithmPane, queenPane, authorPane, helpPane;  //Các cửa sổ làm việc
    @FXML
    private JFXButton runAll, setup;    //Các nút cho CasePane
    @FXML
    private JFXToggleButton runForEach; //Nút chọn chạy Hậu từng con một hoặc không
    @FXML
    private Label label1, label2, label3, label4, label5, label6, label7;   //Hàm mô tả thuật toán
    @FXML
    private JFXTextField input; //Nhập trường hợp cần check
    @FXML
    private ImageView wrong11, wrong12, wrong13, wrong14, wrong15, wrong16, wrong17, wrong18;
    @FXML
    private ImageView wrong21, wrong22, wrong23, wrong24, wrong25, wrong26, wrong27, wrong28;
    @FXML
    private ImageView wrong31, wrong32, wrong33, wrong34, wrong35, wrong36, wrong37, wrong38;
    @FXML
    private ImageView wrong41, wrong42, wrong43, wrong44, wrong45, wrong46, wrong47, wrong48;
    @FXML
    private ImageView wrong51, wrong52, wrong53, wrong54, wrong55, wrong56, wrong57, wrong58;
    @FXML
    private ImageView wrong61, wrong62, wrong63, wrong64, wrong65, wrong66, wrong67, wrong68;
    @FXML
    private ImageView wrong71, wrong72, wrong73, wrong74, wrong75, wrong76, wrong77, wrong78;
    @FXML
    private ImageView wrong81, wrong82, wrong83, wrong84, wrong85, wrong86, wrong87, wrong88;

    //done
    @FXML
    private ImageView done11, done12, done13, done14, done15, done16, done17, done18;
    @FXML
    private ImageView done21, done22, done23, done24, done25, done26, done27, done28;
    @FXML
    private ImageView done31, done32, done33, done34, done35, done36, done37, done38;
    @FXML
    private ImageView done41, done42, done43, done44, done45, done46, done47, done48;
    @FXML
    private ImageView done51, done52, done53, done54, done55, done56, done57, done58;
    @FXML
    private ImageView done61, done62, done63, done64, done65, done66, done67, done68;
    @FXML
    private ImageView done71, done72, done73, done74, done75, done76, done77, done78;
    @FXML
    private ImageView done81, done82, done83, done84, done85, done86, done87, done88;

    //upleftdone
    @FXML
    private ImageView upleftdone11, upleftdone12, upleftdone13, upleftdone14, upleftdone15, upleftdone16, upleftdone17, upleftdone18;
    @FXML
    private ImageView upleftdone21, upleftdone22, upleftdone23, upleftdone24, upleftdone25, upleftdone26, upleftdone27, upleftdone28;
    @FXML
    private ImageView upleftdone31, upleftdone32, upleftdone33, upleftdone34, upleftdone35, upleftdone36, upleftdone37, upleftdone38;
    @FXML
    private ImageView upleftdone41, upleftdone42, upleftdone43, upleftdone44, upleftdone45, upleftdone46, upleftdone47, upleftdone48;
    @FXML
    private ImageView upleftdone51, upleftdone52, upleftdone53, upleftdone54, upleftdone55, upleftdone56, upleftdone57, upleftdone58;
    @FXML
    private ImageView upleftdone61, upleftdone62, upleftdone63, upleftdone64, upleftdone65, upleftdone66, upleftdone67, upleftdone68;
    @FXML
    private ImageView upleftdone71, upleftdone72, upleftdone73, upleftdone74, upleftdone75, upleftdone76, upleftdone77, upleftdone78;
    @FXML
    private ImageView upleftdone81, upleftdone82, upleftdone83, upleftdone84, upleftdone85, upleftdone86, upleftdone87, upleftdone88;

    //downleftdone

    @FXML
    private ImageView downleftdone11, downleftdone12, downleftdone13, downleftdone14, downleftdone15, downleftdone16, downleftdone17, downleftdone18;
    @FXML
    private ImageView downleftdone21, downleftdone22, downleftdone23, downleftdone24, downleftdone25, downleftdone26, downleftdone27, downleftdone28;
    @FXML
    private ImageView downleftdone31, downleftdone32, downleftdone33, downleftdone34, downleftdone35, downleftdone36, downleftdone37, downleftdone38;
    @FXML
    private ImageView downleftdone41, downleftdone42, downleftdone43, downleftdone44, downleftdone45, downleftdone46, downleftdone47, downleftdone48;
    @FXML
    private ImageView downleftdone51, downleftdone52, downleftdone53, downleftdone54, downleftdone55, downleftdone56, downleftdone57, downleftdone58;
    @FXML
    private ImageView downleftdone61, downleftdone62, downleftdone63, downleftdone64, downleftdone65, downleftdone66, downleftdone67, downleftdone68;
    @FXML
    private ImageView downleftdone71, downleftdone72, downleftdone73, downleftdone74, downleftdone75, downleftdone76, downleftdone77, downleftdone78;
    @FXML
    private ImageView downleftdone81, downleftdone82, downleftdone83, downleftdone84, downleftdone85, downleftdone86, downleftdone87, downleftdone88;

    //upleftwrong
    @FXML
    private ImageView upleftwrong11, upleftwrong12, upleftwrong13, upleftwrong14, upleftwrong15, upleftwrong16, upleftwrong17, upleftwrong18;
    @FXML
    private ImageView upleftwrong21, upleftwrong22, upleftwrong23, upleftwrong24, upleftwrong25, upleftwrong26, upleftwrong27, upleftwrong28;
    @FXML
    private ImageView upleftwrong31, upleftwrong32, upleftwrong33, upleftwrong34, upleftwrong35, upleftwrong36, upleftwrong37, upleftwrong38;
    @FXML
    private ImageView upleftwrong41, upleftwrong42, upleftwrong43, upleftwrong44, upleftwrong45, upleftwrong46, upleftwrong47, upleftwrong48;
    @FXML
    private ImageView upleftwrong51, upleftwrong52, upleftwrong53, upleftwrong54, upleftwrong55, upleftwrong56, upleftwrong57, upleftwrong58;
    @FXML
    private ImageView upleftwrong61, upleftwrong62, upleftwrong63, upleftwrong64, upleftwrong65, upleftwrong66, upleftwrong67, upleftwrong68;
    @FXML
    private ImageView upleftwrong71, upleftwrong72, upleftwrong73, upleftwrong74, upleftwrong75, upleftwrong76, upleftwrong77, upleftwrong78;
    @FXML
    private ImageView upleftwrong81, upleftwrong82, upleftwrong83, upleftwrong84, upleftwrong85, upleftwrong86, upleftwrong87, upleftwrong88;

    //downleftwrong
    @FXML
    private ImageView downleftwrong11, downleftwrong12, downleftwrong13, downleftwrong14, downleftwrong15, downleftwrong16, downleftwrong17, downleftwrong18;
    @FXML
    private ImageView downleftwrong21, downleftwrong22, downleftwrong23, downleftwrong24, downleftwrong25, downleftwrong26, downleftwrong27, downleftwrong28;
    @FXML
    private ImageView downleftwrong31, downleftwrong32, downleftwrong33, downleftwrong34, downleftwrong35, downleftwrong36, downleftwrong37, downleftwrong38;
    @FXML
    private ImageView downleftwrong41, downleftwrong42, downleftwrong43, downleftwrong44, downleftwrong45, downleftwrong46, downleftwrong47, downleftwrong48;
    @FXML
    private ImageView downleftwrong51, downleftwrong52, downleftwrong53, downleftwrong54, downleftwrong55, downleftwrong56, downleftwrong57, downleftwrong58;
    @FXML
    private ImageView downleftwrong61, downleftwrong62, downleftwrong63, downleftwrong64, downleftwrong65, downleftwrong66, downleftwrong67, downleftwrong68;
    @FXML
    private ImageView downleftwrong71, downleftwrong72, downleftwrong73, downleftwrong74, downleftwrong75, downleftwrong76, downleftwrong77, downleftwrong78;
    @FXML
    private ImageView downleftwrong81, downleftwrong82, downleftwrong83, downleftwrong84, downleftwrong85, downleftwrong86, downleftwrong87, downleftwrong88;

    //leftdone
    @FXML
    private ImageView leftdone11, leftdone12, leftdone13, leftdone14, leftdone15, leftdone16, leftdone17, leftdone18;
    @FXML
    private ImageView leftdone21, leftdone22, leftdone23, leftdone24, leftdone25, leftdone26, leftdone27, leftdone28;
    @FXML
    private ImageView leftdone31, leftdone32, leftdone33, leftdone34, leftdone35, leftdone36, leftdone37, leftdone38;
    @FXML
    private ImageView leftdone41, leftdone42, leftdone43, leftdone44, leftdone45, leftdone46, leftdone47, leftdone48;
    @FXML
    private ImageView leftdone51, leftdone52, leftdone53, leftdone54, leftdone55, leftdone56, leftdone57, leftdone58;
    @FXML
    private ImageView leftdone61, leftdone62, leftdone63, leftdone64, leftdone65, leftdone66, leftdone67, leftdone68;
    @FXML
    private ImageView leftdone71, leftdone72, leftdone73, leftdone74, leftdone75, leftdone76, leftdone77, leftdone78;
    @FXML
    private ImageView leftdone81, leftdone82, leftdone83, leftdone84, leftdone85, leftdone86, leftdone87, leftdone88;

    //leftwrong
    @FXML
    private ImageView leftwrong11, leftwrong12, leftwrong13, leftwrong14, leftwrong15, leftwrong16, leftwrong17, leftwrong18;
    @FXML
    private ImageView leftwrong21, leftwrong22, leftwrong23, leftwrong24, leftwrong25, leftwrong26, leftwrong27, leftwrong28;
    @FXML
    private ImageView leftwrong31, leftwrong32, leftwrong33, leftwrong34, leftwrong35, leftwrong36, leftwrong37, leftwrong38;
    @FXML
    private ImageView leftwrong41, leftwrong42, leftwrong43, leftwrong44, leftwrong45, leftwrong46, leftwrong47, leftwrong48;
    @FXML
    private ImageView leftwrong51, leftwrong52, leftwrong53, leftwrong54, leftwrong55, leftwrong56, leftwrong57, leftwrong58;
    @FXML
    private ImageView leftwrong61, leftwrong62, leftwrong63, leftwrong64, leftwrong65, leftwrong66, leftwrong67, leftwrong68;
    @FXML
    private ImageView leftwrong71, leftwrong72, leftwrong73, leftwrong74, leftwrong75, leftwrong76, leftwrong77, leftwrong78;
    @FXML
    private ImageView leftwrong81, leftwrong82, leftwrong83, leftwrong84, leftwrong85, leftwrong86, leftwrong87, leftwrong88;


    /**
     * Todo: Hàm bắt sự kiện cho các nút
     * @param event
     * @throws InterruptedException
     */
    @FXML
    private void handleButtonAction(ActionEvent event) throws InterruptedException {
        //Todo: Xự kiện bấm nút ALGORITHM
        if (event.getTarget() == btn_algorithm) {
            algorithmPane.setVisible(true);
            open1.setVisible(true);
            open2.setVisible(false);
            open3.setVisible(false);
            open4.setVisible(false);
            queenPane.setVisible(false);
            authorPane.setVisible(false);
            helpPane.setVisible(false);
            //Todo: Xự kiện bấm nút CASE
        } else if (event.getTarget() == btn_play) {
            open2.setVisible(true);
            open1.setVisible(false);
            open3.setVisible(false);
            open4.setVisible(false);
            queenPane.setVisible(true);
            algorithmPane.setVisible(false);
            authorPane.setVisible(false);
            helpPane.setVisible(false);
            //Todo: Xự kiện bấm nút AUTHOR
        } else if (event.getTarget() == btn_author) {
            authorPane.setVisible(true);
            open3.setVisible(true);
            open1.setVisible(false);
            open2.setVisible(false);
            open4.setVisible(false);
            algorithmPane.setVisible(false);
            queenPane.setVisible(false);
            helpPane.setVisible(false);
            //Todo: Xự kiện bấm nút HELP
        } else if (event.getTarget() == btn_help) {
            helpPane.setVisible(true);
            open4.setVisible(true);
            open1.setVisible(false);
            open2.setVisible(false);
            open3.setVisible(false);
            algorithmPane.setVisible(false);
            authorPane.setVisible(false);
            queenPane.setVisible(false);
            //Todo: Xự kiện bấm nút SLEEP
        } else if (event.getTarget() == btn_sleep) {
            open1.setVisible(false);
            open2.setVisible(false);
            open3.setVisible(false);
            open4.setVisible(false);
            algorithmPane.setVisible(false);
            authorPane.setVisible(false);
            helpPane.setVisible(false);
            queenPane.setVisible(false);
            //Todo: Xự kiện bấm nút EXIT
        } else if (event.getTarget() == btn_exit) {
            System.exit(0);
        }
    }
    /**
     * Hàm select queen
     * @param i
     * @return
     */
    public ImageView check(int i) {
        switch (i) {
            case 0:
                return queen1;
            case 1:
                return queen2;
            case 2:
                return queen3;
            case 3:
                return queen4;
            case 4:
                return queen5;
            case 5:
                return queen6;
            case 6:
                return queen7;
            default:
                return queen8;
        }
    }
    /**
     *  TODO: Xử lí cho Algorithm Pane
     * Chạy animation
     */
    //TODO: Di chuyển cho Queens
    public void put(ImageView a, double x0, double y0, double x1, double y1, double time){
        Line line = new Line(x0, y0, x1, y1);
        PathTransition transition = new PathTransition();
        transition.setNode(a);
        transition.setDuration(Duration.seconds(Time_delay));
        transition.setDelay(Duration.seconds(time));
        transition.setCycleCount(1);
        transition.setPath(line);
        //transition.setAutoReverse(true);
        transition.play();
        TIME++;
    }
    //TODO: Check Wrong (hiệu ứng fade cho ô Sai)
    public void checkFill(ImageView img, double time){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(img);
        fadeTransition.setDuration(Duration.seconds(Time_delay/2));
        fadeTransition.setDelay(Duration.seconds(time));
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(0.6);
        fadeTransition.setCycleCount(2);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();
        TIME++;
    }
    //TODO: Check Done (hiệu ứng fade cho ô Đúng)
    public void checkDone(ImageView a, ImageView b, ImageView c, double time){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(a);
        fadeTransition.setDuration(Duration.seconds(Time_delay/2));
        fadeTransition.setDelay(Duration.seconds(time));
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(0.6);
        fadeTransition.setCycleCount(2);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();

        FadeTransition fadeTransition1 = new FadeTransition();
        fadeTransition1.setNode(b);
        fadeTransition1.setDuration(Duration.seconds(Time_delay/2));
        fadeTransition1.setDelay(Duration.seconds(time));
        fadeTransition1.setFromValue(0);
        fadeTransition1.setToValue(0.6);
        fadeTransition1.setCycleCount(2);
        fadeTransition1.setAutoReverse(true);
        fadeTransition1.play();

        FadeTransition fadeTransition2 = new FadeTransition();
        fadeTransition2.setNode(c);
        fadeTransition2.setDuration(Duration.seconds(Time_delay/2));
        fadeTransition2.setDelay(Duration.seconds(time));
        fadeTransition2.setFromValue(0);
        fadeTransition2.setToValue(0.6);
        fadeTransition2.setCycleCount(2);
        fadeTransition2.setAutoReverse(true);
        fadeTransition2.play();

        TIME++;
    }
    public void move(ImageView img, double a, double b, double time){
        put(img, a, b, a, b+70, time);
    }

    /**
     *  Tạo Animation cho trường hợp đầu tiên của bài toán 8 hậu...(Chưa hoàn thành... )
     */
    public void placeQueens1(){
        //step1
        put(Queen0, Queen0.getX() + 30, Queen0.getY()+38, Queen0.getX()+30, Queen0.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(done11, Time_delay*TIME);
        //step2
        put(Queen1, Queen1.getX() + 30, Queen1.getY()+38, Queen1.getX()+30, Queen1.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(wrong21, Time_delay*TIME);
        checkFill(leftwrong11, Time_delay*TIME);
        move(Queen1, Queen1.getX()+30, Queen1.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(wrong22, Time_delay*TIME);
        checkFill(upleftwrong11, Time_delay*TIME);
        move(Queen1, Queen1.getX()+30, Queen1.getY()+38+ 95+1*70, Time_delay*TIME);
        checkFill(done23,Time_delay*TIME);
        checkDone(upleftdone12, downleftdone14, leftdone13, Time_delay*TIME);
        //step3
        put(Queen2, Queen2.getX() + 30, Queen2.getY()+38, Queen2.getX()+30, Queen2.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(wrong31, Time_delay*TIME);
        checkFill(leftwrong21, Time_delay*TIME);
        move(Queen2, Queen2.getX()+30, Queen2.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(wrong32, Time_delay*TIME);
        checkFill(downleftwrong23, Time_delay*TIME);
        move(Queen2, Queen2.getX()+30, Queen2.getY()+38+ 95+1*70, Time_delay*TIME);
        checkFill(wrong33, Time_delay*TIME);
        checkFill(upleftwrong22, Time_delay*TIME);
        checkFill(leftwrong23, Time_delay*TIME);
        move(Queen2, Queen2.getX()+30, Queen2.getY()+38+ 95+2*70, Time_delay*TIME);
        checkFill(wrong34, Time_delay*TIME);
        checkFill(upleftwrong23, Time_delay*TIME);
        move(Queen2, Queen2.getX()+30, Queen2.getY()+38+ 95+3*70, Time_delay*TIME);
        checkFill(done35,Time_delay*TIME);
        checkDone(leftdone25, upleftdone24, downleftdone26, Time_delay*TIME);
        //step4
        put(Queen3, Queen3.getX() + 30, Queen3.getY()+38, Queen3.getX()+30, Queen3.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(wrong41, Time_delay*TIME);
        checkFill(leftwrong31, Time_delay*TIME);
        checkFill(downleftwrong32, Time_delay*TIME);
        move(Queen3, Queen3.getX()+30, Queen3.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(done42,Time_delay*TIME);
        checkDone(upleftdone31, leftdone32, downleftdone33, Time_delay*TIME);
        //step5
        put(Queen4, Queen4.getX() + 30, Queen4.getY()+38, Queen4.getX()+30, Queen4.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(wrong51, Time_delay*TIME);
        checkFill(leftwrong41, Time_delay*TIME);
        checkFill(downleftwrong42, Time_delay*TIME);
        move(Queen4, Queen4.getX()+30, Queen4.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(wrong52, Time_delay*TIME);
        checkFill(leftwrong42, Time_delay*TIME);
        move(Queen4, Queen4.getX()+30, Queen4.getY()+38+ 95+1*70, Time_delay*TIME);
        checkFill(wrong53, Time_delay*TIME);
        checkFill(upleftwrong42, Time_delay*TIME);
        checkFill(leftwrong43, Time_delay*TIME);
        checkFill(downleftwrong44, Time_delay*TIME);
        move(Queen4, Queen4.getX()+30, Queen4.getY()+38+ 95+2*70, Time_delay*TIME);
        checkFill(done54,Time_delay*TIME);
        checkDone(upleftdone43  , leftdone44, downleftdone45, Time_delay*TIME);
        //step6
        put(Queen5, Queen5.getX() + 30, Queen5.getY()+38, Queen5.getX()+30, Queen5.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(wrong61, Time_delay*TIME);
        checkFill(leftwrong51, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(wrong62, Time_delay*TIME);
        checkFill(leftwrong52, Time_delay*TIME);
        checkFill(downleftwrong53, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+1*70, Time_delay*TIME);
        checkFill(wrong63, Time_delay*TIME);
        checkFill(leftwrong53, Time_delay*TIME);
        checkFill(downleftwrong54, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+2*70, Time_delay*TIME);
        checkFill(wrong64, Time_delay*TIME);
        checkFill(upleftwrong53, Time_delay*TIME);
        checkFill(leftwrong54, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+3*70, Time_delay*TIME);
        checkFill(wrong65, Time_delay*TIME);
        checkFill(upleftwrong54, Time_delay*TIME);
        checkFill(leftwrong55, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+4*70, Time_delay*TIME);
        checkFill(wrong66, Time_delay*TIME);
        checkFill(upleftwrong55, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+5*70, Time_delay*TIME);
        checkFill(wrong67, Time_delay*TIME);
        checkFill(upleftwrong56, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+6*70, Time_delay*TIME);
        checkFill(wrong68, Time_delay*TIME);
        checkFill(upleftwrong57, Time_delay*TIME);
        put(Queen5, Queen5.getX()+ 30, Queen5.getY()+38 + 95+7*70, Queen5.getX()+30, Queen5.getY()+38, Time_delay*TIME);
        //step7
        move(Queen4, Queen4.getX()+30, Queen4.getY()+38+ 95+3*70, Time_delay*TIME);
        checkFill(wrong55,Time_delay*TIME);
        checkFill(upleftwrong44, Time_delay*TIME);
        checkFill(leftwrong45, Time_delay*TIME);
        move(Queen4, Queen4.getX()+30, Queen4.getY()+38+ 95+4*70, Time_delay*TIME);
        checkFill(wrong56, Time_delay*TIME);
        checkFill(upleftwrong45, Time_delay*TIME);
        move(Queen4, Queen4.getX()+30, Queen4.getY()+38+ 95+5*70, Time_delay*TIME);
        checkFill(wrong57, Time_delay*TIME);
        checkFill(upleftwrong46, Time_delay*TIME);
        move(Queen4, Queen4.getX()+30, Queen4.getY()+38+ 95+6*70, Time_delay*TIME);
        checkFill(done58, Time_delay*TIME);
        checkDone(upleftdone47, leftdone48, null, Time_delay*TIME);
        //step8
        put(Queen5, Queen5.getX() + 30, Queen5.getY()+38, Queen5.getX()+30, Queen5.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(wrong61, Time_delay*TIME);
        checkFill(leftwrong51, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(wrong62, Time_delay*TIME);
        checkFill(leftwrong52, Time_delay*TIME);
        checkFill(downleftwrong53, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+1*70, Time_delay*TIME);
        checkFill(wrong63, Time_delay*TIME);
        checkFill(leftwrong53, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+2*70, Time_delay*TIME);
        checkFill(wrong64, Time_delay*TIME);
        checkFill(upleftwrong53, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+3*70, Time_delay*TIME);
        checkFill(wrong65, Time_delay*TIME);
        checkFill(leftwrong55, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+4*70, Time_delay*TIME);
        checkFill(wrong66, Time_delay*TIME);
        checkFill(upleftwrong55, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+5*70, Time_delay*TIME);
        checkFill(wrong67, Time_delay*TIME);
        checkFill(upleftwrong56, Time_delay*TIME);
        checkFill(downleftwrong58, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+6*70, Time_delay*TIME);
        checkFill(wrong68, Time_delay*TIME);
        checkFill(upleftwrong57, Time_delay*TIME);
        checkFill(leftwrong58, Time_delay*TIME);
        put(Queen5, Queen5.getX()+ 30, Queen5.getY()+38 + 95+7*70, Queen5.getX()+30, Queen5.getY()+38, Time_delay*TIME);
        //step9
        put(Queen4, Queen4.getX()+ 30, Queen4.getY()+38 + 95+7*70, Queen4.getX()+30, Queen4.getY()+38, Time_delay*TIME);
        //step10
        move(Queen3, Queen3.getX()+30, Queen3.getY()+38+ 95+1*70, Time_delay*TIME);
        checkFill(wrong43,Time_delay*TIME);
        checkFill(leftwrong33, Time_delay*TIME);
        move(Queen3, Queen3.getX()+30, Queen3.getY()+38+ 95+2*70, Time_delay*TIME);
        checkFill(wrong44,Time_delay*TIME);
        checkFill(upleftwrong33, Time_delay*TIME);
        checkFill(downleftwrong35, Time_delay*TIME);
        move(Queen3, Queen3.getX()+30, Queen3.getY()+38+ 95+3*70, Time_delay*TIME);
        checkFill(wrong45,Time_delay*TIME);
        checkFill(upleftwrong34, Time_delay*TIME);
        checkFill(leftwrong35, Time_delay*TIME);
        move(Queen3, Queen3.getX()+30, Queen3.getY()+38+ 95+4*70, Time_delay*TIME);
        checkFill(wrong46,Time_delay*TIME);
        checkFill(upleftwrong35, Time_delay*TIME);
        move(Queen3, Queen3.getX()+30, Queen3.getY()+38+ 95+5*70, Time_delay*TIME);
        checkFill(done47,Time_delay*TIME);
        checkDone(upleftdone36, leftdone37, downleftdone38, Time_delay*TIME);
        //step11
        put(Queen4, Queen4.getX() + 30, Queen4.getY()+38, Queen4.getX()+30, Queen4.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(wrong51, Time_delay*TIME);
        checkFill(leftwrong41, Time_delay*TIME);
        move(Queen4, Queen4.getX()+30, Queen4.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(done52, Time_delay*TIME);
        checkDone(upleftdone41, leftdone42, downleftdone43, Time_delay*TIME);
        //step12
        put(Queen5, Queen5.getX() + 30, Queen5.getY()+38, Queen5.getX()+30, Queen5.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(wrong61, Time_delay*TIME);
        checkFill(leftwrong51, Time_delay*TIME);
        checkFill(downleftwrong52, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(wrong62, Time_delay*TIME);
        checkFill(leftwrong52, Time_delay*TIME);
        checkFill(downleftwrong53, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+1*70, Time_delay*TIME);
        checkFill(wrong63, Time_delay*TIME);
        checkFill(upleftwrong52, Time_delay*TIME);
        checkFill(leftwrong53, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+2*70, Time_delay*TIME);
        checkFill(done64, Time_delay*TIME);
        checkDone(upleftdone53, leftdone54, downleftdone55, Time_delay*TIME);
        //step13
        put(Queen6, Queen6.getX() + 30, Queen6.getY()+38, Queen6.getX()+30, Queen6.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(wrong71, Time_delay*TIME);
        checkFill(leftwrong61, Time_delay*TIME);
        checkFill(downleftwrong62, Time_delay*TIME);
        move(Queen6, Queen6.getX()+30, Queen6.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(wrong72, Time_delay*TIME);
        checkFill(leftwrong62, Time_delay*TIME);
        move(Queen6, Queen6.getX()+30, Queen6.getY()+38+ 95+1*70, Time_delay*TIME);
        checkFill(wrong73, Time_delay*TIME);
        checkFill(leftwrong63, Time_delay*TIME);
        checkFill(downleftwrong64, Time_delay*TIME);
        move(Queen6, Queen6.getX()+30, Queen6.getY()+38+ 95+2*70, Time_delay*TIME);
        checkFill(wrong74, Time_delay*TIME);
        checkFill(upleftwrong63, Time_delay*TIME);
        checkFill(leftwrong64, Time_delay*TIME);
        checkFill(downleftwrong65, Time_delay*TIME);
        move(Queen6, Queen6.getX()+30, Queen6.getY()+38+ 95+3*70, Time_delay*TIME);
        checkFill(wrong75, Time_delay*TIME);
        checkFill(upleftwrong64, Time_delay*TIME);
        checkFill(leftwrong65, Time_delay*TIME);
        move(Queen6, Queen6.getX()+30, Queen6.getY()+38+ 95+4*70, Time_delay*TIME);
        checkFill(done76, Time_delay*TIME);
        checkDone(upleftdone65, leftdone66, downleftdone67, Time_delay*TIME);
        //step14
        put(Queen7, Queen7.getX() + 30, Queen7.getY()+38, Queen7.getX()+30, Queen7.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(wrong81, Time_delay*TIME);
        checkFill(leftwrong71, Time_delay*TIME);
        move(Queen7, Queen7.getX()+30, Queen7.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(wrong82, Time_delay*TIME);
        checkFill(leftwrong72, Time_delay*TIME);
        checkFill(downleftwrong73, Time_delay*TIME);
        move(Queen7, Queen7.getX()+30, Queen7.getY()+38+ 95+1*70, Time_delay*TIME);
        checkFill(wrong83, Time_delay*TIME);
        checkFill(leftwrong73, Time_delay*TIME);
        checkFill(downleftwrong74, Time_delay*TIME);
        move(Queen7, Queen7.getX()+30, Queen7.getY()+38+ 95+2*70, Time_delay*TIME);
        checkFill(wrong84, Time_delay*TIME);
        checkFill(leftwrong74, Time_delay*TIME);
        move(Queen7, Queen7.getX()+30, Queen7.getY()+38+ 95+3*70, Time_delay*TIME);
        checkFill(wrong85, Time_delay*TIME);
        checkFill(upleftwrong74, Time_delay*TIME);
        checkFill(leftwrong75, Time_delay*TIME);
        checkFill(downleftwrong76, Time_delay*TIME);
        move(Queen7, Queen7.getX()+30, Queen7.getY()+38+ 95+4*70, Time_delay*TIME);
        checkFill(wrong86, Time_delay*TIME);
        checkFill(upleftwrong75, Time_delay*TIME);
        checkFill(leftwrong76, Time_delay*TIME);
        move(Queen7, Queen7.getX()+30, Queen7.getY()+38+ 95+5*70, Time_delay*TIME);
        checkFill(wrong87, Time_delay*TIME);
        checkFill(upleftwrong76, Time_delay*TIME);
        checkFill(leftwrong77, Time_delay*TIME);
        move(Queen7, Queen7.getX()+30, Queen7.getY()+38+ 95+6*70, Time_delay*TIME);
        checkFill(wrong88, Time_delay*TIME);
        checkFill(upleftwrong77, Time_delay*TIME);
        put(Queen7, Queen7.getX()+ 30, Queen7.getY()+38 + 95+7*70, Queen7.getX()+30, Queen7.getY()+38, Time_delay*TIME);
        //step15
        move(Queen6, Queen6.getX()+30, Queen6.getY()+38+ 95+5*70, Time_delay*TIME);
        checkFill(wrong77, Time_delay*TIME);
        checkFill(upleftwrong66, Time_delay*TIME);
        checkFill(leftwrong67, Time_delay*TIME);
        move(Queen6, Queen6.getX()+30, Queen6.getY()+38+ 95+6*70, Time_delay*TIME);
        checkFill(wrong78, Time_delay*TIME);
        checkFill(upleftwrong67, Time_delay*TIME);
        put(Queen6, Queen6.getX()+ 30, Queen6.getY()+38 + 95+7*70, Queen6.getX()+30, Queen6.getY()+38, Time_delay*TIME);
        //step16
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+3*70, Time_delay*TIME);
        checkFill(wrong65, Time_delay*TIME);
        checkFill(leftwrong55, Time_delay*TIME);
        checkFill(downleftwrong56, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+4*70, Time_delay*TIME);
        checkFill(wrong66, Time_delay*TIME);
        checkFill(upleftwrong55, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+5*70, Time_delay*TIME);
        checkFill(wrong67, Time_delay*TIME);
        checkFill(upleftwrong56, Time_delay*TIME);
        checkFill(leftwrong57, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+6*70, Time_delay*TIME);
        checkFill(wrong68, Time_delay*TIME);
        checkFill(upleftwrong57, Time_delay*TIME);
        put(Queen5, Queen5.getX()+ 30, Queen5.getY()+38 + 95+7*70, Queen5.getX()+30, Queen5.getY()+38, Time_delay*TIME);
        //step17
        move(Queen4, Queen4.getX()+30, Queen4.getY()+38+ 95+1*70, Time_delay*TIME);
        checkFill(wrong53, Time_delay*TIME);
        checkFill(leftwrong43, Time_delay*TIME);
        checkFill(downleftwrong44,Time_delay*TIME);
        move(Queen4, Queen4.getX()+30, Queen4.getY()+38+ 95+2*70, Time_delay*TIME);
        checkFill(done54, Time_delay*TIME);
        checkDone(upleftdone43, leftdone44, downleftdone45, Time_delay*TIME);
        //step18
        put(Queen5, Queen5.getX() + 30, Queen5.getY()+38, Queen5.getX()+30, Queen5.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(wrong61, Time_delay*TIME);
        checkFill(leftwrong51, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+0*70, Time_delay*TIME);
        checkFill(wrong62, Time_delay*TIME);
        checkFill(downleftwrong53, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+1*70, Time_delay*TIME);
        checkFill(wrong63, Time_delay*TIME);
        checkFill(leftwrong53, Time_delay*TIME);
        checkFill(downleftwrong54, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+2*70, Time_delay*TIME);
        checkFill(wrong64, Time_delay*TIME);
        checkFill(leftwrong54, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+3*70, Time_delay*TIME);
        checkFill(wrong65, Time_delay*TIME);
        checkFill(upleftwrong54, Time_delay*TIME);
        checkFill(downleftwrong56, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+4*70, Time_delay*TIME);
        checkFill(wrong66, Time_delay*TIME);
        checkFill(upleftwrong55, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+5*70, Time_delay*TIME);
        checkFill(wrong67, Time_delay*TIME);
        checkFill(upleftwrong56, Time_delay*TIME);
        checkFill(leftwrong57, Time_delay*TIME);
        move(Queen5, Queen5.getX()+30, Queen5.getY()+38+ 95+6*70, Time_delay*TIME);
        checkFill(wrong68, Time_delay*TIME);
        checkFill(upleftwrong57, Time_delay*TIME);
        put(Queen5, Queen5.getX()+ 30, Queen5.getY()+38 + 95+7*70, Queen5.getX()+30, Queen5.getY()+38, Time_delay*TIME);
        //step19
        move(Queen4, Queen4.getX()+30, Queen4.getY()+38+ 95+3*70, Time_delay*TIME);
        checkFill(wrong55, Time_delay*TIME);
        checkFill(upleftwrong44, Time_delay*TIME);
        checkFill(leftwrong45, Time_delay*TIME);
        move(Queen4, Queen4.getX()+30, Queen4.getY()+38+ 95+4*70, Time_delay*TIME);
        checkFill(wrong56, Time_delay*TIME);
        checkFill(upleftwrong45, Time_delay*TIME);
        checkFill(downleftwrong47, Time_delay*TIME);
        move(Queen4, Queen4.getX()+30, Queen4.getY()+38+ 95+5*70, Time_delay*TIME);
        checkFill(wrong57, Time_delay*TIME);
        checkFill(upleftwrong46, Time_delay*TIME);
        checkFill(leftwrong47, Time_delay*TIME);
        move(Queen4, Queen4.getX()+30, Queen4.getY()+38+ 95+6*70, Time_delay*TIME);
        checkFill(wrong58, Time_delay*TIME);
        checkFill(upleftwrong47, Time_delay*TIME);

        put(Queen4, Queen4.getX()+ 30, Queen4.getY()+38 + 95+7*70, Queen4.getX()+30, Queen4.getY()+38, Time_delay*TIME);
        put(Queen3, Queen3.getX()+ 30, Queen3.getY()+38 + 95+7*70, Queen3.getX()+30, Queen3.getY()+38, Time_delay*TIME);
        put(Queen2, Queen2.getX()+ 30, Queen2.getY()+38 + 95+7*70, Queen2.getX()+30, Queen2.getY()+38, Time_delay*TIME);
        put(Queen1, Queen1.getX()+ 30, Queen1.getY()+38 + 95+7*70, Queen1.getX()+30, Queen1.getY()+38, Time_delay*TIME);
        put(Queen0, Queen0.getX()+ 30, Queen0.getY()+38 + 95+7*70, Queen0.getX()+30, Queen0.getY()+38, Time_delay*TIME);

        //step20

//        put(Queen7, Queen7.getX() + 30, Queen7.getY()+33, Queen7.getX()+30, Queen7.getY()+33+ 700+0*70, Time_delay*TIME);
//        move(Queen7, Queen7.getX()+30, Queen7.getY()+33+ 700+0*70, Time_delay*TIME);
//        move(Queen7, Queen7.getX()+30, Queen7.getY()+33+ 700+7*70, Time_delay*TIME);
//        move(Queen7, Queen7.getX()+30, Queen7.getY()+33+ 700+2*70, Time_delay*TIME);
//        move(Queen7, Queen7.getX()+30, Queen7.getY()+33+ 700+3*70, Time_delay*TIME);
//        move(Queen7, Queen7.getX()+30, Queen7.getY()+33+ 700+4*70, Time_delay*TIME);
//        move(Queen7, Queen7.getX()+30, Queen7.getY()+33+ 700+5*70, Time_delay*TIME);
//        move(Queen7, Queen7.getX()+30, Queen7.getY()+33+ 700+6*70, Time_delay*TIME);
//        put(Queen7, Queen7.getX()+ 30, Queen7.getY()+33 + 700+7*70, Queen7.getX()+30, Queen7.getY()+33, Time_delay*TIME);
    }

    /**
     * TODO: Xử lí cho CASE Pane
     * @param event
     * @throws InterruptedException
     */

    //TODO: Bắt sự kiện cho các nút trong case pane
    @FXML
    private void handleClicked(ActionEvent event) throws InterruptedException {
        if (event.getTarget() == runAll) {
            int a = Integer.parseInt(input.getText());
            current = a-1;
            System.out.println("Phương án vừa chọn: " + (current+1));
            queenSolution(0, current);
            count = 0;
            input.setText("");
        }
        if (event.getTarget() == btn_backStep) {
            current--;
            if (current >= 0) {
                System.out.println("Phương án vừa chọn: " + (current+1));
                queenSolution(0, current);
                count = 0;
            }
        }
        if (event.getTarget() == btn_nextStep) {
            current++;
            if (current <= 91) {
                System.out.println("Phương án vừa chọn: " + (current+1));
                queenSolution(0, current);
                count = 0;
            }
        }
    }

    //TODO : Xủ lí sự kiện khi bấm vào For Each Button
    @FXML
    private void selection(ActionEvent event){
        check = runForEach.isSelected();
    }

    @FXML
    private void playAlgorithmPane(ActionEvent event){
        TIME = 0;
        placeQueens1();
    }



    /**
     * hàm xử lí chạy 8 Queen cùng 1 lúc
     */
    public void out() {
        //TODO: Chạy 8 con Hậu lần lượt
        if(check){
            for (int i = 0; i < n; i++) {
                putQueens(check(i), check(i).getX() + 30, check(i).getY() + 38, check(i).getX() + 30, check(i).getY() + 38 + 100 + queens[i] * 70, Time_delay*i);
            }
        }
        //TODO: Chạy 8 con Hậu cùng 1 lúc
        else{
            for (int i = 0; i < n; i++) {
                putQueens(check(i), check(i).getX() + 30, check(i).getY() + 38, check(i).getX() + 30, check(i).getY() + 38 + 100 + queens[i] * 70, 0);
            }
        }

    }

    /**
     * Hàm đặt Hậu vào vị trí thích hợp
     * @param a
     * @param x0
     * @param y0
     * @param x1
     * @param y1
     */
    public void putQueens(ImageView a, double x0, double y0, double x1, double y1, double time) {
        Line line = new Line(x0, y0, x1, y1);
        PathTransition transition = new PathTransition();
        transition.setNode(a);
        transition.setDuration(Duration.seconds(Time_delay));
        transition.setDelay(Duration.seconds(time));
        transition.setCycleCount(1);
        transition.setPath(line);
        //transition.setAutoReverse(true);
        transition.play();
    }
    /**
     * Hàm xử lí sự kiện in ra board với Phương án là số nhập vào!!
     *
     * @param i
     * @throws InterruptedException s
     */
    public void queenSolution(int i, int num) throws InterruptedException {
        for (int j = 0; j < n; j++) {
            if (row[j] == 1 && cross1[i + j] == 1 && cross2[j - i + n] == 1) {
                queens[i] = j;
                //putQueens(check(i), check(i).getX()+30, check(i).getY()+33, check(i).getX()+30, check(i).getY()+33+ 85+j*70);
                row[j] = 0;
                cross1[i + j] = 0;
                cross2[j - i + n] = 0;
                if (i == n - 1) {
                    if (count == num) {
                        out();
                        //break;
                    }
                    count++;
                } else {
                    queenSolution(i + 1, num);
                }

                row[j] = 1;
                cross1[i + j] = 1;
                cross2[j - i + n] = 1;
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
