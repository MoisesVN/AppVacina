import { View, Text, TouchableOpacity, Image } from "react-native";
import { useNavigation } from "@react-navigation/native";
import styles from "./style";

export default function Info() {
    const navigation = useNavigation();
    return (
        <View style={styles.Tela1}>
            <View style={styles.Tela}>
                <TouchableOpacity onPress={() => navigation.navigate("Home")} style={styles.botao}>
                    <Image source={require("../imagens/kisspng-brand-logo-black-and-white-triangle-arrow-symbol-5a76c6d1df2c13.8388288415177335859141 (1).png")} />
                </TouchableOpacity>


                <View style={styles.Divdecima}>
                    <View style={styles.nomeIdade}>
                        <Text style={styles.Txt}>nome: João</Text>
                        <Text>idade: 3 anos</Text>
                    </View>
                    <View style={styles.imgdePerfil}>
                        <Text>Imagem aqui!</Text>
                    </View>
                </View>
                <View style={styles.DivdoMeio}>
                <Text style={styles.textMeio}>
                    adic. foto
                </Text>
                </View>

                <View style={styles.DivdoMeio}>
                <Text style={styles.textMeio}>
                    alergias
                </Text>
                </View>
            <View style={styles.divconteiner}>
                <View style={styles.DivdeBaixo}>
                    <Text>Próxima vacina</Text>
                </View>
            </View> 

            </View>
        </View>
    )
}
