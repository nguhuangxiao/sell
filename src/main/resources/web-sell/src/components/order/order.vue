<template>
    <div class="order-container">
        <div class="choose-address">
            选择收货地址>
        </div>
        <div class="estimate-info">
            <div class="time-box">
                <div class="estimate-time">
                    <div>送达时间</div>
                    <span>准时达PLU服务：超过十分钟起享现金服务</span>
                </div>
                <div class="time">
                    尽快送达（11:27送达）
                </div>
            </div>
            <div class="pay-type">
                支付方式
                <div class="type-label">支付宝></div>
            </div>
        </div>

        <div class="product-info">
            <div class="address">米多面多（藏龙岛店）</div>
            <div class="product" v-for="item in order" :key="index">
                <img :src="item.src"/>
                <span class="name">{{item.name}}</span>
                <span class="number">x<i>{{item.count}}</i></span>
                <div class="single-totle">¥{{item.price}}</div>
            </div>
            <ul class="other-cost" >
                <li>
                    <label>包装费</label>餐盒<span>¥2</span>
                </li>
                <li>
                    <label>配送费</label>蜂鸟专送<span>¥4</span>
                </li>
            </ul>
        </div>

        <div class="totle-price">
            <div>¥18.5 <span>已优惠</span> ¥3</div>
            <div class="receiveOrder">确认支付</div>
        </div>

    </div>
</template>

<script type="text/ecmascript-6">


    export default {
        name: 'Order',
        components: {

        },
        props: {

        },
        data() {
            return {
                order: [],
                detailShow: false
            };
        },
        methods: {
            reserveOrder() {
                console.log(this.$route.params.order)
                this.order = this.$route.params.order;
            }
        },
        created() {

        },
        mounted() {
            console.log(1)
            this.reserveOrder();
        }

    };
</script>

<style lang="stylus" rel="stylesheet/stylus">
    @import "../../common/stylus/mixin";
    body{
        background: #e3e5e6;
    }
    .order-container{
        padding 20px;
    }
    .choose-address{
        color: #fff;
        font-size:20px;
    }
    .estimate-info{
        background: #fff;
        font-size: 14px;
        padding: 10px;
        margin: 10px 0;
        .time-box{
            display flex;
            justify-content space-between;
        }
        .pay-type{
            display flex;
            justify-content space-between;
        }
    }
    .product-info{
        background: #fff;
        padding: 10px;
        .product{
            display flex;
            align-items center;
            margin: 10px 0;
            img{
                width 60px;
                height 60px;
                display block;
            }
            .name{
                width: 50%;
                margin: 0 10px;
            }
        }
    }
</style>
