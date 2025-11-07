package com.rusty.whiskeybackend.config;

import com.rusty.whiskeybackend.domain.Pairing;
import com.rusty.whiskeybackend.domain.Whiskey;
import com.rusty.whiskeybackend.domain.WhiskeyCategory;
import com.rusty.whiskeybackend.domain.WhiskeySubCategory;
import com.rusty.whiskeybackend.repository.WhiskeyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final WhiskeyRepository whiskeyRepository;

    @Override
    public void run(String... args) throws Exception {
        if (whiskeyRepository.count() > 0) {
            log.info("샘플 데이터가 이미 존재합니다. 초기화를 건너뜁니다.");
            return;
        }

        log.info("샘플 위스키 데이터를 초기화합니다...");

        List<Whiskey> sampleWhiskeys = new ArrayList<>();

        // 1. 더 글렌리벳 12년
        sampleWhiskeys.add(Whiskey.builder()
                .name("더 글렌리벳 12년")
                .englishName("The Glenlivet 12 Year Old")
                .brand("Glenlivet")
                .category(WhiskeyCategory.SINGLE_MALT)
                .subCategories(List.of(WhiskeySubCategory.SHERRY))
                .abv(40.0)
                .volume(700.0)
                .nation("스코틀랜드")
                .region("스페이사이드")
                .notes("부드럽고 달콤한 스페이사이드 싱글몰트")
                .nose("바닐라, 아몬드, 꿀의 향")
                .palate("부드러운 과일향과 오크의 균형")
                .finish("중간 길이의 달콤한 여운")
                .personalNote("입문자에게 추천하는 부드러운 위스키")
                .starPoint(4.0)
                .pairings(List.of(
                        new Pairing("🍫", "다크 초콜릿"),
                        new Pairing("🧀", "부드러운 치즈")
                ))
                .flavorTags(List.of("부드러움", "달콤함", "과일향", "바닐라"))
                .build());

        // 2. 라프로익 10년
        sampleWhiskeys.add(Whiskey.builder()
                .name("라프로익 10년")
                .englishName("Laphroaig 10 Year Old")
                .brand("Laphroaig")
                .category(WhiskeyCategory.SINGLE_MALT)
                .subCategories(List.of(WhiskeySubCategory.PEAT))
                .abv(40.0)
                .volume(700.0)
                .nation("스코틀랜드")
                .region("아일라")
                .notes("강렬한 피트와 스모키한 아일라 위스키")
                .nose("강한 피트, 요오드, 바다 향")
                .palate("스모키하고 약간의 단맛")
                .finish("길고 강렬한 피트 여운")
                .personalNote("피트 애호가를 위한 클래식")
                .starPoint(4.0)
                .pairings(List.of(
                        new Pairing("🥩", "훈제 고기"),
                        new Pairing("🦞", "해산물")
                ))
                .flavorTags(List.of("피트", "스모키", "약품", "바다"))
                .build());

        // 3. 맥캘란 12년 셰리오크
        sampleWhiskeys.add(Whiskey.builder()
                .name("맥캘란 12년 셰리오크")
                .englishName("Macallan 12 Year Old Sherry Oak")
                .brand("Macallan")
                .category(WhiskeyCategory.SINGLE_MALT)
                .subCategories(List.of(WhiskeySubCategory.SHERRY))
                .abv(40.0)
                .volume(700.0)
                .nation("스코틀랜드")
                .region("스페이사이드")
                .notes("풍부한 셰리 캐스크 숙성의 깊은 맛")
                .nose("말린 과일, 생강, 오렌지")
                .palate("셰리의 달콤함과 스파이시함")
                .finish("긴 여운의 말린 과일과 스파이스")
                .personalNote("셰리 캐스크의 정석")
                .starPoint(4.0)
                .pairings(List.of(
                        new Pairing("🍰", "과일 케이크"),
                        new Pairing("🥜", "견과류")
                ))
                .flavorTags(List.of("셰리", "과일", "스파이시", "오크"))
                .build());

        // 4. 조니워커 블랙 라벨
        sampleWhiskeys.add(Whiskey.builder()
                .name("조니워커 블랙 라벨")
                .englishName("Johnnie Walker Black Label")
                .brand("Johnnie Walker")
                .category(WhiskeyCategory.BLENDED_MALT)
                .subCategories(List.of())
                .abv(40.0)
                .volume(700.0)
                .nation("스코틀랜드")
                .region("스페이사이드")
                .notes("균형잡힌 블렌디드 스카치")
                .nose("스모키, 과일, 바닐라")
                .palate("크리미하고 스모키한 맛")
                .finish("중간 길이의 스모키한 여운")
                .personalNote("가성비 좋은 블렌디드 위스키")
                .starPoint(4.0)
                .pairings(List.of(
                        new Pairing("🍔", "버거"),
                        new Pairing("🥓", "베이컨")
                ))
                .flavorTags(List.of("스모키", "균형", "부드러움"))
                .build());

        // 5. 야마자키 12년
        sampleWhiskeys.add(Whiskey.builder()
                .name("야마자키 12년")
                .englishName("Yamazaki 12 Year Old")
                .brand("Suntory")
                .category(WhiskeyCategory.WORLD_WHISKEY)
                .subCategories(List.of())
                .abv(43.0)
                .volume(700.0)
                .nation("일본")
                .region("야마자키")
                .notes("일본 위스키의 대표작")
                .nose("과일, 꿀, 미즈나라 오크")
                .palate("복숭아, 파인애플, 계피")
                .finish("달콤하고 긴 여운")
                .personalNote("섬세하고 우아한 재패니즈 위스키")
                .starPoint(4.0)
                .pairings(List.of(
                        new Pairing("🍣", "스시"),
                        new Pairing("🍡", "화과자")
                ))
                .flavorTags(List.of("과일", "꿀", "섬세함", "우아함"))
                .build());

        // 6. 탱커레이 런던 드라이 진
        sampleWhiskeys.add(Whiskey.builder()
                .name("탱커레이 런던 드라이 진")
                .englishName("Tanqueray London Dry Gin")
                .brand("Tanqueray")
                .category(WhiskeyCategory.GIN_VODKA)
                .subCategories(List.of())
                .abv(47.3)
                .volume(750.0)
                .nation("영국")
                .region("스페이사이드")
                .notes("클래식 런던 드라이 진")
                .nose("주니퍼 베리, 시트러스")
                .palate("크리스프하고 드라이한 맛")
                .finish("상쾌한 여운")
                .personalNote("진토닉의 정석")
                .starPoint(4.0)
                .pairings(List.of(
                        new Pairing("🍋", "레몬"),
                        new Pairing("🌿", "토닉 워터")
                ))
                .flavorTags(List.of("주니퍼", "시트러스", "드라이", "상쾌함"))
                .build());

        // 7. 샤또 마고 2015
        sampleWhiskeys.add(Whiskey.builder()
                .name("샤또 마고 2015")
                .englishName("Château Margaux 2015")
                .brand("Château Margaux")
                .category(WhiskeyCategory.WINE_LIQUEUR)
                .subCategories(List.of())
                .abv(13.5)
                .volume(750.0)
                .nation("프랑스")
                .region("보르도")
                .notes("보르도 최고급 와인")
                .nose("블랙베리, 바이올렛, 시더")
                .palate("실키하고 우아한 타닌")
                .finish("매우 긴 여운")
                .personalNote("특별한 날을 위한 와인")
                .starPoint(4.0)
                .pairings(List.of(
                        new Pairing("🥩", "스테이크"),
                        new Pairing("🧀", "숙성 치즈")
                ))
                .flavorTags(List.of("우아함", "복합성", "타닌", "과일"))
                .build());

        // 8. 다이긴조 사케
        sampleWhiskeys.add(Whiskey.builder()
                .name("다이긴조 준마이")
                .englishName("Daiginjo Junmai Sake")
                .brand("타테야마")
                .category(WhiskeyCategory.SAKE_TRADITIONAL)
                .subCategories(List.of())
                .abv(16.0)
                .volume(720.0)
                .nation("일본")
                .region("기후")
                .notes("프리미엄 일본 사케")
                .nose("과일, 꽃향기, 쌀")
                .palate("깨끗하고 섬세한 맛")
                .finish("부드럽고 상쾌한 여운")
                .personalNote("차갑게 또는 미지근하게")
                .starPoint(4.0)
                .pairings(List.of(
                        new Pairing("🍣", "사시미"),
                        new Pairing("🦐", "새우 튀김")
                ))
                .flavorTags(List.of("섬세함", "과일", "깨끗함", "부드러움"))
                .build());

        // 9. 기네스 드래프트
        sampleWhiskeys.add(Whiskey.builder()
                .name("기네스 드래프트")
                .englishName("Guinness Draught")
                .brand("Guinness")
                .category(WhiskeyCategory.BEER)
                .subCategories(List.of())
                .abv(4.2)
                .volume(440.0)
                .nation("영국")
                .region("아이리시")
                .notes("아이리시 스타우트의 대표")
                .nose("로스티드 몰트, 커피")
                .palate("크리미하고 부드러운 질감")
                .finish("약간 쓴 여운")
                .personalNote("캔으로도 드래프트 느낌")
                .starPoint(4.0)
                .pairings(List.of(
                        new Pairing("🥧", "미트 파이"),
                        new Pairing("🦪", "굴")
                ))
                .flavorTags(List.of("로스티드", "커피", "크리미", "부드러움"))
                .build());

        // 10. 버팔로 트레이스
        sampleWhiskeys.add(Whiskey.builder()
                .name("버팔로 트레이스")
                .englishName("Buffalo Trace Kentucky Straight Bourbon")
                .brand("Buffalo Trace")
                .category(WhiskeyCategory.WORLD_WHISKEY)
                .subCategories(List.of(WhiskeySubCategory.BOURBON))
                .abv(45.0)
                .volume(750.0)
                .nation("미국")
                .region("켄터키")
                .notes("켄터키 버번의 클래식")
                .nose("바닐라, 캐러멜, 오크")
                .palate("달콤한 옥수수와 라이 스파이스")
                .finish("긴 여운의 캐러멜과 오크")
                .personalNote("가성비 좋은 버번")
                .starPoint(4.0)
                .pairings(List.of(
                        new Pairing("🍖", "바비큐"),
                        new Pairing("🥧", "피칸 파이")
                ))
                .flavorTags(List.of("바닐라", "캐러멜", "오크", "스파이시"))
                .build());

        whiskeyRepository.saveAll(sampleWhiskeys);

        log.info("총 {}개의 샘플 위스키 데이터가 초기화되었습니다.", sampleWhiskeys.size());
    }
}
